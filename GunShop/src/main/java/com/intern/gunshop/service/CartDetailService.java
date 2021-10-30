package com.intern.gunshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.entity.Cart;
import com.intern.gunshop.entity.Cart_Detail;
import com.intern.gunshop.entity.Gun_Color;
import com.intern.gunshop.repository.CartDetailRepository;
import com.intern.gunshop.repository.CartRepository;
import com.intern.gunshop.repository.GunColorRepository;

@Service
public class CartDetailService {

	@Autowired
	private CartDetailRepository cartDetailRepo;
	
	@Autowired
	private GunColorRepository gunColorRepo;
	
	@Autowired
	private CartRepository cartRepo;
	
	public List<Cart_Detail> getCartDetail(Integer cart_id){
		List<Cart_Detail> detail = null;
		detail = cartDetailRepo.findByCartId(cart_id);
		return detail;
	}
	
	public Cart_Detail addDetail(Integer colored_id, Integer cart_id, Integer cart_quantity) {
		Cart_Detail detail = new Cart_Detail();
		
		Gun_Color gunColor = gunColorRepo.findById(colored_id).get();
		Cart cart = cartRepo.findById(cart_id).get();
		
		detail.setCart(cart);
		detail.setGuns(gunColor);
		detail.setCart_quantity(cart_quantity);
		
		return cartDetailRepo.save(detail);
	}
}
