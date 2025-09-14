package com.example.college_placement_website.college_placement_website.dto;

import com.example.college_placement_website.college_placement_website.entity.Placement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DashboardStatsDto {

    private Long totalPlacements;
    private List<Object[]> companyWiseStats;
    private List<Object[]> departmentWiseStats;
    private List<Placement> recentPlacements;

    public DashboardStatsDto(){}

    public DashboardStatsDto(Long totalPlacements,List<Object[]>companyWiseStats,List<Object[]>departmentWiseStats,List<Placement>recentPlacements)
    {
        this.totalPlacements=totalPlacements;
        this.companyWiseStats=companyWiseStats;
        this.departmentWiseStats=departmentWiseStats;
        this.recentPlacements=recentPlacements;
    }

}
