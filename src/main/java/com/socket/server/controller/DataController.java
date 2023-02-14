package com.socket.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DataController {

    private final SimpMessageSendingOperations messagingTemplate;

    @PostMapping("/broadcast/{roomId}")
    public ResponseEntity<?> dataMessage(@RequestBody Object data, @PathVariable String roomId) {
        messagingTemplate.convertAndSend("/sub/message/user/" + roomId, data);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
