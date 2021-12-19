package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;

@RestController
class itemController {

  private final ItemRepository repository;

  itemController(ItemRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/items")
  List<Item> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/add/item")
  Item newItem(@RequestBody Item newItem) {
	  
    return repository.save(newItem);
  }

  // Single item
  
  @GetMapping("/items/{id}")
  Object one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new ItemNotFoundException(id));
  }


}