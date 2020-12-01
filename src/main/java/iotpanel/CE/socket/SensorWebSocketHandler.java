package iotpanel.CE.socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.List;

public class SensorWebSocketHandler implements WebSocketHandler {
    public List<WebSocketSession> webSocketSessions = new ArrayList<>();

    public List<WebSocketSession> getWebSocketSessions() {
        return webSocketSessions;
    }

    public void setWebSocketSessions(List<WebSocketSession> webSocketSessions) {
        this.webSocketSessions = webSocketSessions;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        webSocketSessions.add(webSocketSession);
        System.out.println(webSocketSessions.size());
        System.out.println(webSocketSession.toString());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        //     System.out.println(webSocketMessage.getPayload().toString().substring(1, webSocketMessage.getPayload().toString().length()-1).replaceAll("\\\\",""));//.replaceAll("\\\\","")
        // User convertedObject = new Gson().fromJson(webSocketMessage.getPayload().toString().substring(1, webSocketMessage.getPayload().toString().length()-1).replaceAll("\\\\",""), User.class);
        System.out.println(webSocketMessage.getPayload().toString());
        // Show it.
        //  System.out.println(convertedObject);
        // ObjectMapper mapper = new ObjectMapper();
        // Map<String,Object> map = mapper.readValue((DataInput) webSocketMessage.getPayload(), Map.class);
        for(WebSocketSession mainwebSocketSession : webSocketSessions){
            mainwebSocketSession.sendMessage(webSocketMessage);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        webSocketSessions.remove(webSocketSession);
        System.out.println(webSocketSessions.size());


    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public synchronized Integer getOnlineCount() {
        return webSocketSessions.size();
    }
}
