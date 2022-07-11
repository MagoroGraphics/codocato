package com.codocato.codocato.models;

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
    
    @Column(name="gameIntroAnimation")
    private String lottieGameIntro;
    
    @Column(name="gameOutroAnimation")
    private String lottieGameOutro;
    
    @Column(name="isComplete")
    private boolean isComplete;
    
    @Column(name="pointValue")
    private int pointsValue;
    
    @OneToOne(mappedBy = "game")
    private Lesson lesson;
    
    public Game(String name, boolean isComplete, int pointsValue, String lottieGameIntro,  String lottieGameOutro) {
        this.name = name;
        this.isComplete = isComplete; //might not need this
        this.pointsValue = pointsValue;
        this.lottieGameIntro = lottieGameIntro;
        this.lottieGameOutro = lottieGameOutro;
        //this.lesson = new Lesson();
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
    
    public String getLottieGameIntro() {
        return lottieGameIntro;
    }
    
    public void setLottieGameIntro(String lottieGameIntro) {
        this.lottieGameIntro = lottieGameIntro;
    }
    
    public String getLottieGameOutro() {
        return lottieGameOutro;
    }
    
    public void setLottieGameOutro(String lottieGameOutro) {
        this.lottieGameOutro = lottieGameOutro;
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
