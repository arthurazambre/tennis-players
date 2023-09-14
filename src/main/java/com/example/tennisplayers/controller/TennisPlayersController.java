package com.example.tennisplayers.controller;

import com.example.tennisplayers.model.TennisPlayerData;
import com.example.tennisplayers.model.TennisPlayersData;
import com.example.tennisplayers.service.TennisPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TennisPlayersController {

    private final TennisPlayersService tennisPlayersService;

    @Autowired
    public TennisPlayersController(TennisPlayersService tennisPlayersService) {
        this.tennisPlayersService = tennisPlayersService;
    }

    @GetMapping("/players")
    public TennisPlayersData playersGet() {
        return tennisPlayersService.getData();
    }

    @GetMapping("/players/{id}")
    public TennisPlayerData playersGetById(@PathVariable Long id) {
        return tennisPlayersService.getPlayerData(id);
    }
}
