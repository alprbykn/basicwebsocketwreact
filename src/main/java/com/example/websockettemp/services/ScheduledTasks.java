package com.example.websockettemp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduledTasks {
    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedRate = 5000) // Send every 5 seconds (adjust as needed)
    public void sendCurrentTime() {
        System.out.println("sa");
        String now = LocalDateTime.now().toString();
        template.convertAndSend("/topic/currentTime", now);
    }
}
