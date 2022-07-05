package com.codocato.codocato.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="enrollments")

public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "isComplete")
    private boolean isComplete;
    
    @ManyToOne
    @JsonIgnoreProperties({"enrollments"})
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;
    
    
    @ManyToOne
    @JsonIgnoreProperties({"enrollments"})
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;
    
    public Enrollment(Player player, Lesson lesson) {
        this.isComplete = false;
        this.player = player;
        this.lesson = lesson;
    }
    public Enrollment() {
    }
    public boolean isComplete() {
        return isComplete;
    }
    
    public void setComplete(boolean complete) {
        isComplete = complete;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Lesson getLesson() {
        return lesson;
    }
    
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
