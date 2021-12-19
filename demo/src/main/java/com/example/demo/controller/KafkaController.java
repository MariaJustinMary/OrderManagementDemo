package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.kafka.KafkaSender;
import com.example.demo.model.Order;

@RestController
@RequestMapping("/kafkaapp")
public class KafkaController {
	
	@Autowired
	KafkaSender kafkaSender;
	
	@PostMapping(value="/post")
	public void sendMessage(@RequestParam("order") Order order) {
		//Tested with default values
		order.setItemID("123");
		order.setOrderID("45");
		order.setOrderStatus("PLACED");
		order.setQuantity(5);
		kafkaSender.send(order);
	}

}
