package com.codocato.codocato.controllers;

import com.codocato.codocato.models.Enrollment;
import com.codocato.codocato.models.Lesson;
import com.codocato.codocato.models.Player;
import com.codocato.codocato.repositories.EnrollmentRepository;
import com.codocato.codocato.repositories.LessonRepository;
import com.codocato.codocato.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PlayerController {
    
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    LessonRepository lessonRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;
    
    @GetMapping(value="/players")
    public List<Player>getAllPlayers(){return playerRepository.findAll();}
    
    @GetMapping(value="/players/{id}")
    public Optional<Player> getPlayer(@PathVariable Long id){return playerRepository.findById(id);}
    
    
    @PostMapping(value="/players")
    public ResponseEntity<Player>postPlayer(@RequestBody Player player){
    playerRepository.save(player);

//    get a list of all lesson instances from the database or the repository
        // call the lessonRepo?
        ArrayList <Lesson> allLessons = (ArrayList<Lesson>) lessonRepository.findAll();

//    using forEach, map through these, and for each lesson, create an enrollment instance using the lessonId and the posted playerID

            allLessons.forEach(lesson -> {
                Enrollment enrollment;
                enrollment = new Enrollment(player, lesson);

                enrollmentRepository.save(enrollment);

            }
        );

//    add these enrollments to the player enrollment array

        

    return new ResponseEntity<>(player, HttpStatus.CREATED);
    }
    
    
}
