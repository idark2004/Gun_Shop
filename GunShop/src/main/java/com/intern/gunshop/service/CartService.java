package com.intern.gunshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.entity.Cart;
import com.intern.gunshop.entity.Users;
import com.intern.gunshop.repository.CartRepository;
import com.intern.gunshop.repository.UserRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public Cart addCart(Integer user_id) {
		Users user = userRepo.findById(user_id).get();
		Cart newCart = new Cart();
		newCart.setUser(user);
		
		return cartRepo.save(newCart);
	}	
}
