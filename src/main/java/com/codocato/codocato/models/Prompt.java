package com.codocato.codocato.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="prompts")

public class Prompt {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable=false)
    private Long id;
    @Column(name="name")
    private String name;
    
    @Column(name="imageSrc")
    private String imageSrc;
    
    @Column(name="gameImageSrc")
    private String gameImageSrc;
    @Column(name="fact")
    private  String fact;
    @Column(name="positionX")
    private int positionX;
    @Column(name="positionY")
    private int positionY;
    @JsonIgnoreProperties({"prompts"})
    @ManyToOne()
    @JoinColumn(name="lesson_id")
    private Lesson lesson;
    
    public Prompt() {
    }
    
    public Prompt(String name, String imageSrc, String gameImageSrc, String fact, int positionX, int positionY) {
        this.name = name;
        this.imageSrc = imageSrc;
        this.gameImageSrc = gameImageSrc;
        this.fact = fact;
        this.positionX = positionX;
        this.positionY = positionY;
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
    
    public String getImageSrc() {
        return imageSrc;
    }
    
    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }
    
    public String getGameImageSrc() {
        return gameImageSrc;
    }
    
    public void setGameImageSrc(String gameImageSrc) {
        this.gameImageSrc = gameImageSrc;
    }
    
    public String getFact() {
        return fact;
    }
    
    public void setFact(String fact) {
        this.fact = fact;
    }
    
    public int getPositionX() {
        return positionX;
    }
    
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    
    public int getPositionY() {
        return positionY;
    }
    
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    
    public Lesson getLesson() {
        return lesson;
    }
    
    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    
    //endregion
    
}
