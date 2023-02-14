package com.socket.server.controller;

import com.socket.server.model.UserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/broadcast/{roomId}")
    public void userMessage(@RequestBody Object data, @PathVariable String roomId) {
        messagingTemplate.convertAndSend("/sub/message/user/" + roomId, data);
    }
}