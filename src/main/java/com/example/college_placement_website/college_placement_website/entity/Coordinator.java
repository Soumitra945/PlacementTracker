package com.example.college_placement_website.college_placement_website.entity;

import com.example.college_placement_website.college_placement_website.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="coordinator")
@Getter
@Setter
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Role role=Role.COORDINATOR;

    private boolean active=true;

    public Coordinator(){}

    public Coordinator(String username,String password,String email,String fullName)
    {
        this.username=username;
        this.password=password;
        this.email=email;
        this.fullName=fullName;
    }

}
