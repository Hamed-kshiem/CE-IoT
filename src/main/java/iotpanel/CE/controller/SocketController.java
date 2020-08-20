/*
 * Copyright (c) 2020. Hamed  CE
 *
 */

package iotpanel.CE.controller;

import iotpanel.CE.socket.ChatWebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

@RestController
@RequestMapping("socket")
@CrossOrigin(origins = "http://localhost:4200")
public class SocketController {

@Autowired
ChatWebSocketHandler socket;

    @GetMapping("/sensorcout")
    public Integer greeting() throws Exception {
        //Thread.sleep(1000); // simulated delay
        System.out.println(socket.getOnlineCount());
        return socket.getOnlineCount();
    }
}
