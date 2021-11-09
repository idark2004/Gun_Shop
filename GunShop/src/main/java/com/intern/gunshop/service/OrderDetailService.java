package com.intern.gunshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.OrderDetailDTO;
import com.intern.gunshop.entity.Cart_Detail;
import com.intern.gunshop.entity.Gun_Color;
import com.intern.gunshop.entity.Order_Detail;
import com.intern.gunshop.exception.ApiRequestException;
import com.intern.gunshop.repository.CartDetailRepository;
import com.intern.gunshop.repository.CartRepository;
import com.intern.gunshop.repository.GunColorRepository;
import com.intern.gunshop.repository.OrderDetailRepository;
import com.intern.gunshop.repository.OrderRepository;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailRepository repo;

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private CartDetailRepository cdRepo;

	@Autowired
	private OrderRepository ordRepo;
	
	@Autowired
	private GunColorRepository productRepo;

	// Add all item in cart to order
	public List<OrderDetailDTO> addAll(Integer user_id, Integer order_id) {
		// Get user cart
		int cart_id = cartRepo.findByUserId(user_id).getCart_id();
		List<Cart_Detail> cartDetail = cdRepo.findByCartId(cart_id);
		if (cartDetail.isEmpty()) {
			throw new ApiRequestException("No item in cart ! Can't checkout !");
		}

		List<OrderDetailDTO> dtoList = new ArrayList<OrderDetailDTO>();
		// Transfer all item in cart to order
		for (Cart_Detail cd : cartDetail) {
			
			Gun_Color product = cd.getGuns();
			if(product.getQuantity() < cd.getCart_quantity()) {
				throw new ApiRequestException("Sorry! We only have " + product.getQuantity() + " of "+ product.getColored_gun().getGun_name()+ " in our shop!", HttpStatus.FORBIDDEN);
			}
			Order_Detail od = new Order_Detail();
			od.setItem(cd.getGuns());
			od.setOrder_quantity(cd.getCart_quantity());
			od.setOrder_total(cd.getCart_price());
			od.setOrder(ordRepo.findById(order_id).get());
			Order_Detail saved = repo.save(od);
			//Subtract in-store quantity after order
			int in_store = product.getQuantity();
			product.setQuantity(in_store - cd.getCart_quantity());
			productRepo.save(product);
			// map to dto
			OrderDetailDTO dto = new OrderDetailDTO();
			dto.setColor(cd.getGuns().getColor().getColor_name());
			dto.setDetail_id(saved.getDetail_id());
			dto.setGun_name(cd.getGuns().getColored_gun().getGun_name());
			dto.setQuantity(cd.getCart_quantity());
			dto.setTotal(cd.getCart_price());
			dtoList.add(dto);
			// delete item in cart
			cdRepo.delete(cd);
		}

		return dtoList;
	}
}
