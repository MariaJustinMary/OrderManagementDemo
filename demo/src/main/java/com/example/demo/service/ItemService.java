package com.example.demo.service;
import com.example.demo.model.Item;

import java.util.List;


	public interface ItemService {

	    List<com.example.demo.model.Item> findAll();

	    Item findById(long Id);

	    Item saveOrUpdate(Item item);
	}

