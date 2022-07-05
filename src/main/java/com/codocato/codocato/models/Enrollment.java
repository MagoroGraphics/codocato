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
    
    @JsonIgnoreProperties({"pirates"})
    @ManyToOne
    @JoinColumn(name = "ship_id", nullable = false)
    private Ship ship;
    
    private Long playerId;
    private Long LessonId;
    private boolean isComplete;
    
    public Enrollment() {
        this.playerId = player.getId();
    }
    
    @JsonIgnoreProperties({"enrollment"})
    @OneToMany(mappedBy = "enrollment", fetch = FetchType.LAZY)
    private Player player;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
}
