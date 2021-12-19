package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CreateOrderDTO;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@PreAuthorize("#oauth2.hasScope('openid')")
@RequestMapping("/order")
public class OrderController {

	    @Autowired
	    private OrderService orderService;

	    @GetMapping(value = "/byOrderID/{id}")
	    public OrderRepository getOrderDetailsByID(@PathVariable("id") Long id) {
	        return ObjectMapper.map(orderService.findById(id), OrderRepository.class);
	    }

	    @PostMapping(value = "/orders/create")
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDTO createOrderDTO){
	    	createOrderDTO.setOrderStatus("PROCESSED");
	        return new ResponseEntity<>(orderService.createOrder(createOrderDTO), HttpStatus.CREATED);
	    }
	}
}
