package com.codocato.codocato.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    public Player player1;
    Enrollment enrollment1;
    Lesson lesson1;

    @Before
    public void  before() {
        player1 = new Player("Mario", "cat_1.png");
        enrollment1 = new Enrollment(player1, lesson1);
    }

    @Test
    public void hasName() {
        assertEquals("Mario", player1.getName());
    }

    @Test
    public void canChangeName() {
        player1.setName("Mary");
        assertEquals("Mary", player1.getName());
    }

    @Test
    public void hasScore() {
        assertEquals(0, player1.getScore());
    }

    @Test
    public void canChangeScore() {
        player1.setScore(100);
        assertEquals(100, player1.getScore());
    }

    @Test
    public void doesNotHaveEnrollmentsToStart() {
        assertEquals(0, player1.getEnrollments().size());
    }

    @Test
    public void hasAvatar() {
        assertEquals("cat_1.png", player1.getAvatar());
    }

    @Test
    public void canChangeAvatar() {
        player1.setAvatar("dog_2.png");
        assertEquals("dog_2.png", player1.getAvatar());
    }
}