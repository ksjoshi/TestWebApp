package com.example.demoservicev1.messaging;

import com.example.demoservicev1.config.ReceivedBinding;
import com.example.demoservicev1.config.SentBinding;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProcessReceivedMessage {

    @StreamListener(value = ReceivedBinding.INPUT)
    @SendTo(value = ReceivedBinding.OUTPUT)
    public String processReceivedMessage(String msg) {
       log.info("Received msg is {}", msg);

        return msg;
    }

    @StreamListener(value = SentBinding.INPUT)
    public void processSentMessage(String msg) {
        log.info("Received msg is {}", msg);
    }

    @StreamListener(value = SentBinding.INPUT)
    public void processSentMessageListener(String msg) {
        log.info("Received msg on second listener is {}", msg);
    }
}
