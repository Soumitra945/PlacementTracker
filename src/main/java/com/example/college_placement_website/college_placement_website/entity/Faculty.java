package com.example.college_placement_website.college_placement_website.entity;

import com.example.college_placement_website.college_placement_website.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="faculty")
@Getter
@Setter
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable=false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String department;

    @Enumerated(EnumType.STRING)
    private Role role=Role.FACULTY;

    private boolean active=true;

    public Faculty(){}

    public Faculty(String username,String password,String fullName,String email,String department)
    {
        this.username=username;
        this.password=password;
        this.email=email;
        this.fullName=fullName;
        this.department=department;
    }



}
