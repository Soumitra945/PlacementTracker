package com.example.college_placement_website.college_placement_website.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="hsc")
@Getter
@Setter
public class HSC extends Qualification{

    private String stream="Science";

}
