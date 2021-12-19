package com.example.demo.kafka;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.serializer.Deserializer;
import org.springframework.data.mongodb.core.aggregation.VariableOperators.Map;

import com.example.demo.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderDeserializer implements Deserializer {

	  @Override public void close() {

	  }

	  @Override public void configure(Map<String, ?> arg0, boolean arg1) {

	  }

	  @Override
	  public Order deserialize(String arg0, byte[] arg1) {
	    ObjectMapper mapper = new ObjectMapper();
	    Order order = null;
	    try {
	      order = mapper.readValue(arg1, Order.class);
	    } catch (Exception e) {

	      e.printStackTrace();
	    }
	    return order;
	  }

	@Override
	public Object deserialize(InputStream inputStream) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	}