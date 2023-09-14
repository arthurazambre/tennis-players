package com.example.tennisplayers.controller;

import com.example.tennisplayers.model.TennisPlayerData;
import com.example.tennisplayers.model.TennisPlayersData;
import com.example.tennisplayers.service.TennisPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TennisPlayersData> playersGet() {
        return ResponseEntity.ok(tennisPlayersService.getData());
    }

    @GetMapping("/players/{id}")
    public ResponseEntity<TennisPlayerData> playersGetById(@PathVariable Long id) {
        TennisPlayerData result = tennisPlayersService.getPlayerData(id);

        if (result == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(tennisPlayersService.getPlayerData(id));
    }
}
