package com.example.tennisplayers.service;

import com.example.tennisplayers.model.TennisPlayersData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class TennisPlayersService {
    private final TennisPlayersData tennisPlayersData;

    public TennisPlayersService() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassPathResource classPathResource = new ClassPathResource("headtohead.json");
        tennisPlayersData = objectMapper.readValue(classPathResource.getInputStream(), TennisPlayersData.class);
    }

    public TennisPlayersData getData() {
        return tennisPlayersData;
    }
}
