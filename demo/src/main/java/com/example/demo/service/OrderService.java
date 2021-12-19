package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CreateOrderDTO;
import com.example.demo.model.Item;
import com.example.demo.model.Order;


public interface OrderService {
   
	List<Order> findAll();

    Order findById(long Id);

    Item saveOrUpdate(Order orderItem);

	Object createOrder(CreateOrderDTO createOrderDTO);
    
}
