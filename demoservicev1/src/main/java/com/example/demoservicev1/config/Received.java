package com.example.demoservicev1.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface Received {
    @Input(ReceivedBinding.INPUT)
    SubscribableChannel received();

    @Output(ReceivedBinding.OUTPUT)
    SubscribableChannel sentTo();
}
