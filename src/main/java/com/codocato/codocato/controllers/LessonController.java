package com.codocato.codocato.controllers;

import com.codocato.codocato.models.Lesson;
import com.codocato.codocato.models.Player;
import com.codocato.codocato.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LessonController {
    
    @Autowired
    LessonRepository lessonRepository;
    
    @GetMapping(value="/lessons")
    public List<Lesson> getAllLessons(){return lessonRepository.findAll();}
    
    @GetMapping(value="/lessons/{id}")
    public Optional<Lesson> getLesson(@PathVariable Long id){return lessonRepository.findById(id);}
    
    @PostMapping(value="/lessons")
    public ResponseEntity<Lesson> postLesson(@RequestBody Lesson lesson){
        lessonRepository.save(lesson);
        return new ResponseEntity<>(lesson, HttpStatus.CREATED);
    }
}
