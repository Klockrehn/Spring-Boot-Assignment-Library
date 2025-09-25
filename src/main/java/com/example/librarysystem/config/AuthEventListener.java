package com.example.librarysystem.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthEventListener {

    private static final Logger logger = LoggerFactory.getLogger(AuthEventListener.class);

    @EventListener
    public void handleSuccess(AuthenticationSuccessEvent event) {
        String user = (event.getAuthentication() != null) ? event.getAuthentication().getName() : "UNKNOWN";
        logger.info("event=LOGIN_SUCCESS user={}", user);
    }

    @EventListener
    public void handleFailure(AbstractAuthenticationFailureEvent event) {
        String user = (event.getAuthentication() != null) ? event.getAuthentication().getName() : "UNKNOWN";
        String reason = (event.getException() != null) ? event.getException().getMessage() : "unknown";
        logger.warn("event=LOGIN_FAILURE user={} reason={}", user, reason);
    }
}
