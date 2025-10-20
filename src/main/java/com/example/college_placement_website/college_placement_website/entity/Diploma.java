package com.example.college_placement_website.college_placement_website.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Diploma extends Qualification{
    private String specialization;
}
