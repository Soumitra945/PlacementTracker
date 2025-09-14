package com.example.college_placement_website.college_placement_website.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlacementStatsDto {

    private Long totalPlacements;
    private Double averageCTC;
    private Double totalStipend;
    private String department;
    private Integer year;

    public PlacementStatsDto(){}

    public PlacementStatsDto(Long totalPlacements,Double averageCTC,Double totalStipend)
    {
        this.totalPlacements=totalPlacements;
        this.averageCTC=averageCTC;
        this.totalStipend=totalStipend;
    }

}
