package com.example.demo.kafka;

public class MsgSenderTest extends KafkaProducerApplicationTest {
    @Autowired
    MsgSender sender;

    @Test
    public void send() {
        sender.send("This is Kafka Message content sent" + System.currentTimeMillis());
    }
}