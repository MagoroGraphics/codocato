package com.codocato.codocato.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnrollmentTest {

    public Enrollment enrollment;
    public Lesson lesson1;
    public Lesson lesson2;
    public Player player1;
    public Player player2;

    @Before
    public void before() {

        lesson1 = new Lesson("Data Types", false, 100, "lesson1_bg-01.svg");
        lesson2 = new Lesson("Variables", false, 200, "lesson1_bg-01.svg");
        player1 = new Player("Mario", "cat_1.png");
        player2 = new Player("David", "cat_2.png");
        enrollment = new Enrollment(player1, lesson1);
    }

    @Test
    public void CheckIfEnrollmentIsComplete() {
        assertFalse(enrollment.isComplete());
    }

    @Test
    public void canChangeIfEnrollmentIsComplete() {
        enrollment.setComplete(true);
        assertTrue(enrollment.isComplete());
    }

    @Test
    public void hasPlayer() {
        assertEquals(player1, enrollment.getPlayer());
    }

    @Test
    public void canChangePlayer() {
        enrollment.setPlayer(player2);
        assertEquals(player2, enrollment.getPlayer());
    }

    @Test
    public void hasLesson() {
        assertEquals(lesson1, enrollment.getLesson());
    }

    @Test
    public void canChangeLesson() {
        enrollment.setLesson(lesson2);
        assertEquals(lesson2, enrollment.getLesson());
    }
}