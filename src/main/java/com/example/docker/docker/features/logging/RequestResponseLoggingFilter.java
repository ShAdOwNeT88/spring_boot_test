package com.example.docker.docker.features.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class RequestResponseLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logRequest(request);
        filterChain.doFilter(request, response);
        logResponse(response);
    }

    private void logRequest(HttpServletRequest request) {
        System.out.println("Request: " + request.getMethod() + " " + request.getRequestURI());
    }

    private void logResponse(HttpServletResponse response) {
        System.out.println("Response: " + response.getStatus());
    }


}
