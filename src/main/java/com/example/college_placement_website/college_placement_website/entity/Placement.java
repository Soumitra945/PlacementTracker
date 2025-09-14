package com.example.college_placement_website.college_placement_website.entity;

import com.example.college_placement_website.college_placement_website.enums.PlacementStatus;
import com.example.college_placement_website.college_placement_website.enums.PlacementType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "placements")
@Getter
@Setter

public class Placement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="placement_students",
            joinColumns = @JoinColumn(name="placement_id"),
            inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private List<Student> students=new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id",nullable = false)
    private Company company;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private Double ctcAmount;

    private Double stipendAmount;

    @Column(nullable = false)
    private LocalDate placementDate;

    @Enumerated(EnumType.STRING)
    private PlacementType placementType;

    @Enumerated(EnumType.STRING)
    private PlacementStatus placementStatus=PlacementStatus.OFFERED;

    private String workLocation;
    private String remarks;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;

    public Placement(){}

    public Placement(List<Student>students,Company company,String jobTitle,Double ctcAmount,LocalDate placementDate)
    {
        this.students=students;
        this.company=company;
        this.jobTitle=jobTitle;
        this.ctcAmount=ctcAmount;
        this.placementDate=placementDate;
    }


}
