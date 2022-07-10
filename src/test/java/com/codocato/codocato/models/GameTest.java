package com.codocato.codocato.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    public Game game1;

    @Before
    public void before() {
        game1 = new Game("Data types sorting", false, 500);
    }

    @Test
    public void hasName() {
        assertEquals("Data types sorting", game1.getName());
    }

    @Test
    public void canChangeName() {
        game1.setName("Values");
        assertEquals("Values", game1.getName());
    }

    @Test
    public void CheckIfIsComplete() {
        assertFalse(game1.isComplete());
    }

    @Test
    public void canChangeIfIsComplete() {
        game1.setComplete(true);
        assertTrue(game1.isComplete());
    }

    @Test
    public void hasPointsValue() {
        assertEquals(500, game1.getPointsValue());
    }

    @Test
    public void canChangePointsValue() {
        game1.setPointsValue(100);
        assertEquals(100, game1.getPointsValue());
    }
}