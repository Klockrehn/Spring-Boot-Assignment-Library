package com.example.librarysystem.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        ServletWebRequest webRequest = new ServletWebRequest(request);

        Map<String, Object> attributes =
                errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());

        int status = (int) attributes.getOrDefault("status", 500);

        Map<String, Object> body = new HashMap<>();
        body.put("status", status);

        if (status == 404) {
            body.put("error", "Resursen kunde inte hittas.");
        } else if (status == 403) {
            body.put("error", "Åtkomst nekad.");
        } else if (status == 500) {
            body.put("error", "Ett internt serverfel inträffade.");
        } else {
            body.put("error", "Ett oväntat fel inträffade.");
        }

        return ResponseEntity.status(HttpStatus.valueOf(status)).body(body);
    }
}
