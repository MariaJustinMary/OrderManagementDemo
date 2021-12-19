package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.yaml.snakeyaml.events.Event.ID;

import com.example.demo.model.Item;

public interface ItemRepository<T> extends MongoRepository<T, ID> {

	    
	    @Query("{name:'?0'}")
	    Item findItemByName(String name);
	    
	    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	    List<Item> findAll(String category);
	    
	    public long count();


}
