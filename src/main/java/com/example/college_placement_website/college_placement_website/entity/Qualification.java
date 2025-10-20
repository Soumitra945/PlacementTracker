package com.example.college_placement_website.college_placement_website.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "qualification")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String qualificationName;

    private String qualificationType; // e.g., "Diploma", "Degree", "HSC"
    private String board;
    private String university;
    private Integer passingYear;
    private Double percentage;

    // Constructors
    public Qualification() {}

    public Qualification(String qualificationName, String qualificationType) {
        this.qualificationName = qualificationName;
        this.qualificationType = qualificationType;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQualificationName() { return qualificationName; }
    public void setQualificationName(String qualificationName) { this.qualificationName = qualificationName; }

    public String getQualificationType() { return qualificationType; }
    public void setQualificationType(String qualificationType) { this.qualificationType = qualificationType; }

    public String getBoard() { return board; }
    public void setBoard(String board) { this.board = board; }

    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }

    public Integer getPassingYear() { return passingYear; }
    public void setPassingYear(Integer passingYear) { this.passingYear = passingYear; }

    public Double getPercentage() { return percentage; }
    public void setPercentage(Double percentage) { this.percentage = percentage; }
}