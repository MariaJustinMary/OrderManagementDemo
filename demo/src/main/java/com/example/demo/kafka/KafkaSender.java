package com.example.demo.kafka;

import java.io.Serializable;
import java.util.UUID;

import javax.annotation.Resource;
import javax.websocket.SendResult;

import org.apache.catalina.Globals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

import com.example.demo.model.Order;

@Component
@Service
public class KafkaSender {

    private static final String myOrder = null;
	@Autowired
    private Globals globals;
    public static final String Topic = "myOrder";
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * Send message method
     * @param msg
     */
    public ResponseEntity send(Order msg) {
        log.info("send message,Message content : {}", msg);
        try {
            String uuid = UUID.randomUUID().toString();
            String topic = globals.getTopic();

            ListenableFuture listenableFuture = kafkaTemplate.send(topic, msg);

            //Callback after sending successfully
            SuccessCallback<SendResult<String,String>> successCallback = new SuccessCallback<SendResult<String,String>>() {
                @Override
                public void onSuccess(SendResult<String,String> result) {
                    log.info("Message sent successfully");
                }
            };
            //Send failed callback
            FailureCallback failureCallback = new FailureCallback() {
                @Override
                public void onFailure(Throwable ex) {
                    log.error("Failed to send message", ex);
                }
            };

            listenableFuture.addCallback(successCallback,failureCallback);
        }catch (Exception e){
            log.error("Sending message exception", e);
        }
        return new ResponseEntity("", HttpStatus.OK);
    }
}
