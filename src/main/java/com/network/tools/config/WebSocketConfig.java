package com.network.tools.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/socket")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app")
                .enableSimpleBroker("/message");
    }




//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/topic");
//        registry.setApplicationDestinationPrefixes("/app");
//    }


//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedMethods("*").allowedOriginPatterns("http://*.domain.com");
//            }
//        };
//    }
}