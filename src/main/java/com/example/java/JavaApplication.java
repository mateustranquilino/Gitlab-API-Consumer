package com.example.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class JavaApplication {

    private static final String BASE_URL = "https://gitlab.com/api/v4";

    @Bean
    public WebClient getWebClientBuilder(WebClient.Builder builder){
        return builder
                .baseUrl(BASE_URL)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

}
