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
    
        
        
        Lesson lesson1 = new Lesson("Data Types", false, 100, "lesson1_bg-01.svg");
        Lesson lesson2 = new Lesson("Variables", false, 200, "lesson1_bg-01.svg");


        Game game1 = new Game("Data types sorting", false, 500);
        Game game2 = new Game("Data types sorting 2", false, 800);
        //gameRepository.save(game1);
        lesson1.setGame(game1);
        //This updates
        lessonRepository.save(lesson1);
        lesson2.setGame(game2);
        lessonRepository.save(lesson2);
        
        
   
        Prompt prompt1 = new Prompt("boolean", "lesson_prompts/off-switch.svg", "A boolean is..", 500, 200);
        Prompt prompt2 = new Prompt("string", "lesson_prompts/_banana_.svg", "A string is..", 500, 200);
        Prompt prompt3 = new Prompt("integer", "lesson_prompts/7-01.svg", "An integer is..", 500, 200);
        Prompt prompt4 = new Prompt("float", "lesson_prompts/1-5_float.svg", "A double is..", 500, 200);
        
        //Prompt exists alone
        promptRepository.save(prompt1);
        promptRepository.save(prompt2);
        promptRepository.save(prompt3);
        promptRepository.save(prompt4);
        
        //Set saved lesson to a prompt
        prompt1.setLesson(lesson1);
        prompt2.setLesson(lesson1);
        prompt3.setLesson(lesson1);
        prompt4.setLesson(lesson1);

        //Prompt exists WITH lesson as lesson as saved first and then assigned to prompt and prompt is then saVED
        promptRepository.save(prompt1);
        promptRepository.save(prompt2);
        promptRepository.save(prompt3);
        promptRepository.save(prompt4);
    
        
        Player player1 = new Player("Mario", "cat_1.png");
        playerRepository.save(player1);

        Enrollment enrollment1 = new Enrollment(player1, lesson1);
        enrollmentRepository.save(enrollment1);
    
        //Example of an update because it HAS AN ID
        //lesson1.setName("ddd");
        //lessonRepository.save(lesson1);
    }
}
