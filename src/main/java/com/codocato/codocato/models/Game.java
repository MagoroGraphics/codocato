package com.codocato.codocato.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="isComplete")
    private boolean isComplete;
    
    @Column(name="pointValue")
    private int pointsValue;
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
    
    public Game(String name, boolean isComplete, int pointsValue) {
        this.name = name;
        this.isComplete = isComplete;
        this.pointsValue = pointsValue;
        this.lesson = new Lesson();
    }
    
    public Game() {
    }
    
    
    //region Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isComplete() {
        return isComplete;
    }
    
    public void setComplete(boolean complete) {
        isComplete = complete;
    }
    
    public int getPointsValue() {
        return pointsValue;
    }
    
    public void setPointsValue(int pointsValue) {
        this.pointsValue = pointsValue;
    }
    
    public Lesson getLesson() {
        return lesson;
    }
    
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    //endregion
    
}
