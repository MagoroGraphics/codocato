package com.codocato.codocato.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
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
    @JsonIgnoreProperties({"lessons"})
    @ManyToOne(optional=false)
    @JoinColumn(name="player_id", nullable=false)
    private Player player;
    
    public Lesson(String name, boolean isComplete, int pointValue, Player player) {
        this.name = name;
        this.isComplete = isComplete;
        this.pointValue = pointValue;
        this.player = player;
        
    }
    
    public Lesson() {
    }
    
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
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public List<Prompt> getPrompts() {
        return prompts;
    }
    
    public void setPrompts(List<Prompt> prompts) {
        this.prompts = prompts;
    }
}
