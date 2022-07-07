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
    GameRepository gameRepository;
    
    @Autowired
    PlayerRepository playerRepository;
    
    @Autowired
    LessonRepository lessonRepository;
    
    @Autowired
    PromptRepository promptRepository;
    
    @Autowired
    EnrollmentRepository enrollmentRepository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
    
//        enrollmentRepository.deleteAll();
//        playerRepository.deleteAll();
//        gameRepository.deleteAll();
//        promptRepository.deleteAll();
//        lessonRepository.deleteAll();
    
        
        
        Lesson lesson1 = new Lesson("Data Types", false, 100);

        Game game1 = new Game("Data types sorting", false, 500);
        lesson1.setGame(game1);
        lessonRepository.save(lesson1);
        gameRepository.save(game1);
   
        Prompt prompt1 = new Prompt("boolean", "true1.png", "A boolean is..", 500, 200);
        Prompt prompt2 = new Prompt("boolean", "true1.png", "A boolean is..", 500, 200);
        
        //Prompt exists alone
        promptRepository.save(prompt2);
        
        //Set saved lesson to a prompt
        prompt1.setLesson(lesson1);
        //Prompt exists WITH lesson as lesson as saved first and then assigned to prompt and prompt is then saVED
        promptRepository.save(prompt1);
    
        
        Player player1 = new Player("Mario", "cat_1.png", 0);
        playerRepository.save(player1);

        Enrollment enrollment1 = new Enrollment(player1, lesson1);
        enrollmentRepository.save(enrollment1);
    
        //Example of an update because it HAS AN ID
        //lesson1.setName("ddd");
        //lessonRepository.save(lesson1);
    }
}
