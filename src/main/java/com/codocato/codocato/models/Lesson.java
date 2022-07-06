package com.codocato.codocato.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="lessons")

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="isComplete")
    private boolean isComplete;
    
    @Column(name="pointValue")
    private int pointValue;
    
    @JsonIgnoreProperties({"lesson"})
    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
    private List<Prompt> prompts;
    
    
    @JsonIgnoreProperties({"lesson"})
    @OneToMany(mappedBy = "lesson", fetch = FetchType.LAZY)
    private List<Enrollment> enrollments;
    
    @OneToOne(mappedBy = "lesson", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Game game;
    
    public Lesson(String name, boolean isComplete, int pointValue, Game game) {
        this.name = name;
        this.isComplete = isComplete;
        this.pointValue = pointValue;
        this.enrollments = new ArrayList<>();
        this.game = game;
        this.prompts = new ArrayList<>();
    }
    
    public Lesson() {
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
    
    public int getPointValue() {
        return pointValue;
    }
    
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }
    
    public List<Prompt> getPrompts() {
        return prompts;
    }
    
    public void setPrompts(List<Prompt> prompts) {
        this.prompts = prompts;
    }
    
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    
    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
    
    public Game getGame() {
        return game;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    public void addPrompt(Prompt prompt){
        this.prompts.add(prompt);
    }
    
    //endregion
}
