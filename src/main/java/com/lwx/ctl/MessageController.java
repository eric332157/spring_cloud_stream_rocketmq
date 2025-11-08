package com.lwx.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zeus
 * @date 2025/11/8 20
 * @description:
 */
@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        boolean result = streamBridge.send("my-topic",MessageBuilder.withPayload(message).build());
        return result ? "Message sent" : "Failed to send message";
    }
}
