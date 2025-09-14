package com.example.college_placement_website.college_placement_website.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="company")
@Getter
@Setter
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String companyName;

    private String industry;
    private String location;
    private String website;
    private String hrContactName;
    private String hrContactNumber;
    private String hrEmail;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    List<Placement>placements=new ArrayList<>();

    public Company(){}

    public Company(String companyName,String industry,String location)
    {
        this.companyName=companyName;
        this.industry=industry;
        this.location=location;
    }




}
