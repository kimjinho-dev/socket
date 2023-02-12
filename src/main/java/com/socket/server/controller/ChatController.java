package com.socket.server.controller;

import com.socket.server.model.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 채팅 데이터
@RequiredArgsConstructor
@RestController
@RequestMapping
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/message/user")
    public void userMessage(UserMessage message) {
        messagingTemplate.convertAndSend("/sub/message/user/" + message.getRoomId(), message);
    }
}