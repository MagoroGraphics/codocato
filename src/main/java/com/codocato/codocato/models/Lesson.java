package com.codocato.codocato.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

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
    
    @Column(name="backgroundImageUrl")
    private String bgImgUrl;
    
    @JsonIgnoreProperties({"lesson"})
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Prompt> prompts;
    
    @JsonIgnoreProperties({"lesson"})
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;
    
    //@JsonIgnoreProperties({"lesson"})
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"lesson"})
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false)
    private Game game;
    
    

    public Lesson(String name, boolean isComplete, int pointValue, String bgImgUrl) {
        this.name = name;
        this.isComplete = isComplete; //might not need this
        this.pointValue = pointValue;
        this.bgImgUrl = bgImgUrl;
        this.enrollments = new ArrayList<>();
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
    
    public String getBgImgUrl() {
        return bgImgUrl;
    }
    
    public void setBgImgUrl(String bgImgUrl) {
        this.bgImgUrl = bgImgUrl;
    }
    
    //endregion
}
