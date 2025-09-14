package com.example.college_placement_website.college_placement_website.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="ssc")
@Getter
@Setter
public class SSC{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double percentage;

    @Column(nullable = false)
    private Integer passingOutYear;

    public SSC(){}

    public SSC(Double percentage,Integer passingOutYear)
    {
        this.percentage=percentage;
        this.passingOutYear=passingOutYear;
    }

}
