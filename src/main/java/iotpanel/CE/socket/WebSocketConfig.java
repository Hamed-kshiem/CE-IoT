package iotpanel.CE.socket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {


    private final static String CHAT_ENDPOINT = "/chat";
    private final static String SENSOR_ENDPOINT = "/chat/sensor/**";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(getChatWebSocketHandler(),CHAT_ENDPOINT ).addHandler(getSensorWebSocketHandler(),SENSOR_ENDPOINT).setAllowedOrigins("*");
    }

    @Bean
    public WebSocketHandler getChatWebSocketHandler(){
        return new ChatWebSocketHandler();
    }
    @Bean
    public WebSocketHandler getSensorWebSocketHandler(){
        return new SensorWebSocketHandler();
    }
}
