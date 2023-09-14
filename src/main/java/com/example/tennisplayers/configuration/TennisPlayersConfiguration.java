package com.example.tennisplayers.configuration;

import com.example.tennisplayers.service.TennisPlayersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class TennisPlayersConfiguration {

    @Bean
    public TennisPlayersService tennisPlayersService() throws IOException {
        return new TennisPlayersService();
    }
}
