package com.example.demo.kafka;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.core.serializer.Serializer;
import org.springframework.data.mongodb.core.aggregation.VariableOperators.Map;

import com.example.demo.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderSerializer implements Serializer {


		  @Override 
		  public void configure(Map<String, ?> map, boolean b) {

		  }

		  @Override 
		  public byte[] serialize(String arg0, Order arg1) {
		    byte[] retVal = null;
		    ObjectMapper objectMapper = new ObjectMapper();
		    try {
		      retVal = objectMapper.writeValueAsString(arg1).getBytes();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return retVal;
		  }

		  @Override 
		  public void close() {

		  }

		@Override
		public void serialize(Object object, OutputStream outputStream) throws IOException {
			// TODO Auto-generated method stub
			
		}

}
