package com.example.college_placement_website.college_placement_website.entity;

import com.example.college_placement_website.college_placement_website.enums.PlacementStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String prn;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String personalEmail;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private Integer graduationYear;

    @Column(nullable = false)
    private Double cgpa;

    @Column(nullable = false)
    private String phoneNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;

    @Column(nullable = false)
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ssc_id")
    private SSC ssc;

    @Column(nullable = false)
    private PlacementStatus placementStatus;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Placement> placements=new ArrayList<>();

    public Student(){}

    public Student(String prn,String fullName,String Email,String department,String personalEmail,String phoneNo,Double cgpa,Integer graduationYear,String gender,String degree,SSC ssc,Qualification qualification,PlacementStatus placementStatus,List<Placement>placements)
    {
        this.prn=prn;
        this.fullName=fullName;
        this.email=email;
        this.department=department;
        this.personalEmail=personalEmail;
        this.phoneNo=phoneNo;
        this.cgpa=cgpa;
        this.gender=gender;
        this.graduationYear=graduationYear;
        this.qualification=qualification;
        this.ssc=ssc;
        this.placementStatus=placementStatus;
        this.placements=placements;
    }



}
