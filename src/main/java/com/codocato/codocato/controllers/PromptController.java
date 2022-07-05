package com.codocato.codocato.controllers;

import com.codocato.codocato.models.Player;
import com.codocato.codocato.models.Prompt;
import com.codocato.codocato.repositories.PlayerRepository;
import com.codocato.codocato.repositories.PromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PromptController {
    
    @Autowired
    PromptRepository promptRepository;
    
    @GetMapping(value="/prompts")
    public List<Prompt> getAllPrompts(){return promptRepository.findAll();}
    
    @GetMapping(value="/prompts/{id}")
    public Optional<Prompt> getPrompt(@PathVariable Long id){return promptRepository.findById(id);}
    
    @PostMapping(value="/prompts")
    public ResponseEntity<Prompt> postPrompt(@RequestBody Prompt prompt){
        promptRepository.save(prompt);
        return new ResponseEntity<>(prompt, HttpStatus.CREATED);
    }
}

