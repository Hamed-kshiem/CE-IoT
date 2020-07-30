/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.controller;

import iotpanel.CE.socket.ChatWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/socket")
public class SocketController {

@Autowired
ChatWebSocketHandler socketHandler;


    @RequestMapping("/")
    public List<WebSocketSession> index () {
        System.out.println(socketHandler.webSocketSessions.size());
        return socketHandler.getWebSocketSessions();
    }
}
