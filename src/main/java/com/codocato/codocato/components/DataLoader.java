package com.codocato.codocato.components;

import com.codocato.codocato.models.*;
import com.codocato.codocato.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    
    @Autowired
    PlayerRepository playerRepository;
    
    @Autowired
    LessonRepository lessonRepository;
    
    @Autowired
    PromptRepository promptRepository;

    @Autowired
    EnrollmentRepository enrollmentRepository;
    
    @Autowired
    GameRepository gameRepository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
    
//        enrollmentRepository.deleteAll();
//        playerRepository.deleteAll();
//        gameRepository.deleteAll();
//        promptRepository.deleteAll();
//        lessonRepository.deleteAll();
        
        Player player1 = new Player("Mario", 0);
        playerRepository.save(player1);
    
        Game game1 = new Game("Data types sorting", false, 500);
        gameRepository.save(game1);
        
        Lesson lesson1 = new Lesson("Data Types", false, 100, game1);
        lessonRepository.save(lesson1);

        Lesson lesson2 = new Lesson("Data Types", false, 100, game1);
        lessonRepository.save(lesson2);

        Prompt prompt1 = new Prompt("boolean", "true1.png", "A boolean is..", 500, 200);
        promptRepository.save(prompt1);

        
//
//        Enrollment enrollment1 = new Enrollment(player1, lesson1);
//        enrollmentRepository.save(enrollment1);
        
    
    
    
    
    }
}
