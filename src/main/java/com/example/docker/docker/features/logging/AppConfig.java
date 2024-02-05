package com.example.docker.docker.features.logging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RequestResponseLoggingFilter loggingFilter() {
        return new RequestResponseLoggingFilter();
    }
}
