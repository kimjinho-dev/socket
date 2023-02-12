package com.socket.server.model;

import lombok.*;

@Getter
@Setter
public class UserMessage {
    private String roomId; // 방번호
    private String nickname; // 메시지 보낸사람
    private String message; // 메시지
}