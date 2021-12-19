package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.demo.model.Item;
import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;

public interface OrderRepository<T> extends MongoRepository<T, ID> {

	    @Query("{name:'?0'}")
	    Item findOrderByName(String name);
	    
	    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	    List<Order> findAll(String category);
	    
	    public long count();

}
