package com.codocato.codocato.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="players")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    
    private Long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="score")
    private int score;
    
//    @JsonIgnoreProperties({"players"})
@JsonIgnoreProperties({"player"})
@OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
private List<Enrollment> enrollments;

    
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.enrollments = new ArrayList<Enrollment>();
    }
    
    public Player() {
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
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    
    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }
    //endregion
}
