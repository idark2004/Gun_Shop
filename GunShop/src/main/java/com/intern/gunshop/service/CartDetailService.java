package com.intern.gunshop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.CartDetailDTO;
import com.intern.gunshop.entity.Cart;
import com.intern.gunshop.entity.Cart_Detail;
import com.intern.gunshop.entity.Gun;
import com.intern.gunshop.entity.Gun_Color;
import com.intern.gunshop.exception.ApiRequestException;
import com.intern.gunshop.repository.CartDetailRepository;
import com.intern.gunshop.repository.CartRepository;
import com.intern.gunshop.repository.GunColorRepository;
import com.intern.gunshop.util.GetTime;
import com.intern.gunshop.util.Validator;

@Service
public class CartDetailService {

	@Autowired
	private CartDetailRepository cartDetailRepo;

	@Autowired
	private GunColorRepository gunColorRepo;

	@Autowired
	private CartRepository cartRepo;

	//Get item in cart
	public List<CartDetailDTO> getCartDetail(Integer cart_id) {
		List<Cart_Detail> detail = cartDetailRepo.findByCartId(cart_id);
		if (detail.isEmpty()) {
			throw new ApiRequestException("No item in cart", HttpStatus.NOT_FOUND);
		}
		List<CartDetailDTO> dtoList = new ArrayList<CartDetailDTO>();
		for(Cart_Detail d : detail) {
			CartDetailDTO dto = new CartDetailDTO();
			dto.setCart_price(d.getCart_price());
			dto.setCart_quantity(d.getCart_quantity());
			dto.setCde_id(d.getCde_id());
			dto.setColor(d.getGuns().getColor().getColor_name());
			dto.setGun_name(d.getGuns().getColored_gun().getGun_name());
			dtoList.add(dto);
		}
		return dtoList;
	}

	//Add item to cart
	public CartDetailDTO addDetail(Integer colored_id, Integer cart_id, int cart_quantity) {
		Validator.checkCartQuantity(cart_quantity);
		Cart_Detail detail = new Cart_Detail();

		Gun_Color gunColor = gunColorRepo.findById(colored_id).get();
		Cart cart = cartRepo.findById(cart_id).get();
		Gun gun = gunColor.getColored_gun();
		int price = cart_quantity * gun.getGun_price();
		detail.setCart(cart);
		detail.setGuns(gunColor);
		detail.setCart_quantity(cart_quantity);
		detail.setCart_price(price);
		detail.setCreated_date(GetTime.getTimestamp());
		Cart_Detail saved = cartDetailRepo.save(detail);
		CartDetailDTO dto = new CartDetailDTO();
		dto.setCde_id(saved.getCde_id());
		dto.setCart_price(price);
		dto.setCart_quantity(cart_quantity);
		dto.setColor(gunColor.getColor().getColor_name());
		dto.setGun_name(gun.getGun_name());
		return dto;
	}
	
	//Update item's quantity in cart
	public CartDetailDTO updateQuantity(Integer cde_id, int cart_quantity) {
		Validator.checkCartQuantity(cart_quantity);
		Cart_Detail detail = cartDetailRepo.findById(cde_id).get();
		detail.setCart_quantity(cart_quantity);
		int price = detail.getGuns().getColored_gun().getGun_price();
		detail.setCart_price(price * cart_quantity);
		cartDetailRepo.save(detail);
		CartDetailDTO dto = new CartDetailDTO();
		dto.setCde_id(cde_id);
		dto.setCart_price(detail.getCart_price());
		dto.setCart_quantity(cart_quantity);
		dto.setColor(detail.getGuns().getColor().getColor_name());
		dto.setGun_name(detail.getGuns().getColored_gun().getGun_name());
		return dto;
	}
}
