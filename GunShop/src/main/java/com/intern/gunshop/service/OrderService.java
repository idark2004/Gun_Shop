package com.intern.gunshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intern.gunshop.dto.OrderDTO;
import com.intern.gunshop.entity.Orders;
import com.intern.gunshop.entity.Users;
import com.intern.gunshop.exception.ApiRequestException;
import com.intern.gunshop.repository.CartDetailRepository;
import com.intern.gunshop.repository.CartRepository;
import com.intern.gunshop.repository.OrderRepository;
import com.intern.gunshop.repository.UserRepository;
import com.intern.gunshop.util.GetTime;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private CartDetailRepository cdRepo;

	@Autowired
	private UserRepository userRepo;

	// Create an order
	public OrderDTO createOrder(Integer user_id) {
		int cart_id = cartRepo.findByUserId(user_id).getCart_id();
		Users user = userRepo.findById(user_id).get();
		int total_price = cdRepo.totalPriceOfCart(cart_id);
		Orders order = new Orders();
		order.setOrder_status("Accepted");
		order.setOrdered_date(GetTime.getTimestamp());
		order.setTotal_price(total_price);
		order.setUsers(user);
		Orders save = repo.save(order);
		OrderDTO dto = new OrderDTO();
		dto.setOrder_id(save.getOrder_id());
		dto.setOrder_status(order.getOrder_status());
		dto.setOrdered_date(order.getOrdered_date());
		dto.setTotal_price(total_price);
		dto.setUser_name(user.getUser_name());
		return dto;
	}

	// change order status
	public OrderDTO changeStatus(int order_id, String status) {
		Orders order = repo.findById(order_id).get();
		OrderDTO dto = new OrderDTO();
		if (status.contains("Accepted") || status.contains("Completed") || status.contains("Canceled")) {
			order.setOrder_status(status);
			repo.save(order);

			dto.setOrder_id(order_id);
			dto.setOrder_status(status);
			dto.setOrdered_date(order.getOrdered_date());
			dto.setTotal_price(order.getTotal_price());
			dto.setUser_name(order.getUsers().getUser_name());

		} else {
			throw new ApiRequestException("Order status can only be 1 of 3 : Accepted, Completed, Canceled");
		}

		return dto;
	}
}
