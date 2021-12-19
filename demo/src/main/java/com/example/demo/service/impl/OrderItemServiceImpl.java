package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.model.Order;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.OrderService;

public class OrderServiceImpl implements OrderService{
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> findAll() {
        return itemRepository.findAll();
    }


	@Override
	public Order findById(long Id) {
		// TODO Auto-generated method stub
		return ItemRepository.findById(id);
	}

	@Override
	public Item saveOrUpdate(Order order) {
		// TODO Auto-generated method stub
		return ItemRepository.save(order);
	}
}
