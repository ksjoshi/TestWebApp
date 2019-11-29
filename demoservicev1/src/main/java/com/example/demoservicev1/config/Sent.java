package com.example.demoservicev1.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface Sent {
    @Output(SentBinding.INPUT)
    SubscribableChannel sentTo();
}
