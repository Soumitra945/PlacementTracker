package com.example.college_placement_website.college_placement_website.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "qualification")
@Getter
@Setter
public abstract class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;
    private String passingYear;
    private Double percentage;

    public Qualification(){}

    public Qualification(String boardName,String passingYear,Double percentage)
    {
        this.boardName=boardName;
        this.passingYear=passingYear;
        this.percentage=percentage;
    }

}
