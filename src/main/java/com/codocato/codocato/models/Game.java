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
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
}
