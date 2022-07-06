package com.codocato.codocato.controllers;

import com.codocato.codocato.models.Enrollment;
import com.codocato.codocato.models.Game;
import com.codocato.codocato.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    
    @Autowired
    GameRepository gameRepository;
    
    @GetMapping(value="/games")
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }
    
    @GetMapping(value="/games/{id}")
    public Optional<Game> getGame(@PathVariable Long id){
        return gameRepository.findById(id);
    }
    @PostMapping(value="/games")
    public ResponseEntity<Game> postGame(@RequestBody Game game){
        gameRepository.save(game);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }
}
