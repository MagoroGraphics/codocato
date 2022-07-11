package com.codocato.codocato.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LessonTest {

    Lesson lesson1;
    Prompt prompt1;
    Prompt prompt2;

    @Before
    public void before() {
        lesson1 = new Lesson("Data Types", false, 100, "lesson1_bg-01.svg", "leesson1_intro.json");
        prompt1 = new Prompt("boolean", "lesson_prompts/off-switch.svg", "box-boolean.png", "A boolean is..", 500, 200);
        prompt2 = new Prompt("string", "lesson_prompts/_banana_.svg", "_banana_.svg","A string is..", 500, 200);
    }

    @Test
    public void hasName() {
        assertEquals("Data Types", lesson1.getName());
    }

    @Test
    public void canChangeName() {
        lesson1.setName("Values");
        assertEquals("Values", lesson1.getName());
    }

    @Test
    public void checkIfIsComplete() {
        assertFalse(lesson1.isComplete());
    }

    @Test
    public void canChangeIfIsComplete() {
        lesson1.setComplete(true);
        assertTrue(lesson1.isComplete());

    }

    @Test
    public void hasPointValue() {
        assertEquals(100, lesson1.getPointValue());
    }

    @Test
    public void canChangePointValue() {
        lesson1.setPointValue(200);
        assertEquals(200, lesson1.getPointValue());
    }

    @Test
    public void canAddPrompt() {
        lesson1.addPrompt(prompt1);
        lesson1.addPrompt(prompt2);
        assertEquals(2, lesson1.getPrompts().size());
    }

    @Test
    public void hasBgImgUrl() {
        assertEquals("lesson1_bg-01.svg", lesson1.getBgImgUrl());
    }

    @Test
    public void canChangeBgImgUrl() {
        lesson1.setBgImgUrl("lesson2_bg.svg");
        assertEquals("lesson2_bg.svg", lesson1.getBgImgUrl());
    }
}