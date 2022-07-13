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
    
        
        
        Lesson lesson1 = new Lesson("Data Types", false, 100, "lesson1_bg-01.svg", "lesson1_intro.json");
        Lesson lesson2 = new Lesson("Variables", false, 200, "lesson2_bg.jpg", "lesson1_intro.json");


        Game game1 = new Game("Data types sorting", false, 500, "game1_intro.json", "game1_intro.json");
        Game game2 = new Game("Data types sorting 2", false, 800, "lesson1_intro.json", "game1_outro.json");
        //gameRepository.save(game1);
        lesson1.setGame(game1);
        //This updates
        lessonRepository.save(lesson1);
        lesson2.setGame(game2);
        lessonRepository.save(lesson2);

        Prompt prompt1 = new Prompt("boolean", "lesson_prompts/off-switch.svg", "box-boolean.svg","This is a boolean. It is on or off. True or false.", 24, 76);
        Prompt prompt2 = new Prompt("string", "lesson_prompts/_banana_.svg", "box-string.svg","This is a string. It is made up of characters and has quotation marks around it.", 45, 50);
        Prompt prompt3 = new Prompt("integer", "lesson_prompts/7-01.svg", "box-integer.svg","This is an integer. It is a whole number that can be positive or negative.", 25, 35);
        Prompt prompt4 = new Prompt("float", "lesson_prompts/1-5_float.svg", "box-float.svg","This is a float. It is a number with a decimal point", 20, 18);
        
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
    
        
        Player player1 = new Player("Mario", "codocato-avatar1.svg");
        Player player2 = new Player("Emma", "codocato-avatar2.svg");
        Player player3 = new Player("Matt", "codocato-avatar3.svg");
        Player player4 = new Player("Silvia", "codocato-avatar2.svg");
        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);


        Enrollment enrollment1 = new Enrollment(player1, lesson1);
        enrollmentRepository.save(enrollment1);

        Enrollment enrollment2 = new Enrollment(player1, lesson2);
        enrollmentRepository.save(enrollment2);

        Enrollment enrollment3 = new Enrollment(player2, lesson1);
        enrollmentRepository.save(enrollment3);

        Enrollment enrollment4 = new Enrollment(player2, lesson2);
        enrollmentRepository.save(enrollment4);

        Enrollment enrollment5 = new Enrollment(player3, lesson1);
        enrollmentRepository.save(enrollment5);

        Enrollment enrollment6 = new Enrollment(player3, lesson2);
        enrollmentRepository.save(enrollment6);

        Enrollment enrollment7 = new Enrollment(player4, lesson1);
        enrollmentRepository.save(enrollment7);

        Enrollment enrollment8 = new Enrollment(player4, lesson2);
        enrollmentRepository.save(enrollment8);

        //Example of an update because it HAS AN ID
        //lesson1.setName("ddd");
        //lessonRepository.save(lesson1);
    }
}
