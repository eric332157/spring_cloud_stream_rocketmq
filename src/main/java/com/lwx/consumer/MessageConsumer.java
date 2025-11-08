package com.lwx.consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @author zeus
 * @date 2025/11/8 20
 * @description:
 */
@Component
public class MessageConsumer {
    @Bean
    public Consumer<Message<String>> input() {
        return message-> {
            System.out.println("received message :"+message.getPayload());
        };
    }
}
