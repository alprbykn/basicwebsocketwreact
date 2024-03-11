package com.example.websockettemp.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin("*")
@MessageMapping("/app/currentTime")
public class WebSocketController {

    @MessageMapping("/hello")
    public void handleHello(String message, SimpMessagingTemplate template) {
        // Handle incoming messages from the client (if applicable)
    }
}