package com.example.demo.kafka;

import java.util.List;

import org.apache.logging.log4j.EventLogger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jms.JmsProperties.AcknowledgeMode;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;

@Service
public class KafkaBatchConsumer {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = 'myOrderTopic',
            orderID = "myOrder")
    public void listen(List<Order> records, AcknowledgeMode ack) {
        try {
            for (Order record : records) {
                logger.info("receive messages: offset = {}, key = {}, value = {} ",
                        record.offset(), record.key(), record.value());
            }
        } catch (Exception e) {
            EventLogger.error("kafka Receive message exception",e);
        } finally {
            //Manually submit offset
            ack.acknowledge();
        }
    }
}
