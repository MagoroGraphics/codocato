package com.codocato.codocato.controllers;

import com.codocato.codocato.models.Player;
import com.codocato.codocato.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {
    
    @Autowired
    PlayerRepository playerRepository;
    
    @GetMapping(value="/players")
    public List<Player>getAllPlayers(){return playerRepository.findAll();}
    
    @GetMapping(value="/players/{id}")
    public Optional<Player> getPlayer(@PathVariable Long id){return playerRepository.findById(id);}
    
    @PostMapping(value="/players")
    public ResponseEntity<Player>postPlayer(@RequestBody Player player){
    playerRepository.save(player);
    return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
    
    
}
