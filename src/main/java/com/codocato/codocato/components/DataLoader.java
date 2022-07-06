package com.codocato.codocato.components;

import com.codocato.codocato.models.Enrollment;
import com.codocato.codocato.models.Lesson;
import com.codocato.codocato.models.Player;
import com.codocato.codocato.models.Prompt;
import com.codocato.codocato.repositories.EnrollmentRepository;
import com.codocato.codocato.repositories.LessonRepository;
import com.codocato.codocato.repositories.PlayerRepository;
import com.codocato.codocato.repositories.PromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    
    
    promptRepository.deleteAll();
    gameRepository.deleteAll();
    lessonRepository.deleteAll();
    enrollmentRepository.deleteAll();
    playerRepository.deleteAll();
    
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
    
//        ArrayList<Lesson> completedLessons = new ArrayList<>();
//        List<Lesson> upcomingLesson = new ArrayList<>();
//        List<Prompt> prompts = new ArrayList<>();
        
        Player player1 = new Player("Mario", 0);
        playerRepository.save(player1);

        Lesson lesson1 = new Lesson("Data Types", false, 100);
        lessonRepository.save(lesson1);

        Lesson lesson2 = new Lesson("Data Types", false, 100);
        lessonRepository.save(lesson2);

        Prompt prompt1 = new Prompt("boolean", "true1.png", "A boolean is..", 500, 200, lesson1);
        promptRepository.save(prompt1);
    
        Enrollment enrollment1 = new Enrollment(player1, lesson1);
        enrollmentRepository.save(enrollment1);
        
    
    
    
    
    }
}
