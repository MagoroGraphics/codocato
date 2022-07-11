package com.codocato.codocato.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PromptTest {

    Prompt prompt1;

    @Before
    public void before() {
        prompt1 = new Prompt("boolean", "lesson_prompts/off-switch.svg", "A boolean is..", 500, 200);
    }

    @Test
    public void hasName() {
        assertEquals("boolean", prompt1.getName());
    }

    @Test
    public void canChangeName() {
        prompt1.setName("String");
        assertEquals("String", prompt1.getName());
    }

    @Test
    public void hasImageSrc() {
        assertEquals("lesson_prompts/off-switch.svg", prompt1.getImageSrc());
    }

    @Test
    public void canChangeImageSrc() {
        prompt1.setImageSrc("on-switch.svg");
        assertEquals("on-switch.svg", prompt1.getImageSrc());
    }

    @Test
    public void hasFact() {
        assertEquals("A boolean is..", prompt1.getFact());
    }

    @Test
    public void canChangeFact() {
        prompt1.setFact("A string is..");
        assertEquals("A string is..", prompt1.getFact());
    }

    @Test
    public void hasPositionX() {
        assertEquals(500, prompt1.getPositionX());
    }

    @Test
    public void canChangePositionX() {
        prompt1.setPositionX(800);
        assertEquals(800, prompt1.getPositionX());
    }

    @Test
    public void hasPositionY() {
        assertEquals(200, prompt1.getPositionY());
    }

    @Test
    public void setPositionY() {
        prompt1.setPositionY(500);
        assertEquals(500, prompt1.getPositionY());
    }

    @Test
    public void DoesNotHAsLessonToStart() {
        assertEquals(null, prompt1.getLesson());
    }
}