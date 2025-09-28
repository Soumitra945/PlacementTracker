package com.example.college_placement_website.college_placement_website.service;


import com.example.college_placement_website.college_placement_website.dto.DashboardStatsDto;
import com.example.college_placement_website.college_placement_website.dto.PlacementStatsDto;
import com.example.college_placement_website.college_placement_website.entity.Placement;
import com.example.college_placement_website.college_placement_website.respository.PlacementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    public List<Placement> getAllPlacements()
    {
        return placementRepository.findAll();
    }

    public Optional<Placement> getPlacementById(Long id)
    {
        return placementRepository.findById(id);
    }
    public PlacementStatsDto getDepartmentStats(String department,Integer year)
    {
        Long count=placementRepository.countByDepartmentAndYear(department,year);
        Double avgCTC= placementRepository.getAverageCTCByDepartmentAndGraduationUYear(department, year);
        Double maxCTC= placementRepository.getMaxCTCByDepartmentAndGraduationYear(department, year);

        List<Placement>placements=placementRepository.findByStudentDepartmentAndStudentGraduationYear(department, year);

        Double totalStipend=placements.stream()
                .filter(p->p.getStipendAmount()!=null)
                .mapToDouble(Placement::getStipendAmount)
                .sum();

        PlacementStatsDto stats=new PlacementStatsDto(count,avgCTC,totalStipend);
        stats.setDepartment(department);
        stats.setYear(year);

        return stats;
    }

    public Placement savePlacement(Placement placement)
    {
        return placementRepository.save(placement);
    }

    public void deletePlacement(Long id)
    {
        placementRepository.deleteById(id);
    }

    public DashboardStatsDto getDashboardStats()
    {
        Long totalPlacements=placementRepository.count();
        List<Object[]>companyStats=placementRepository.getCompanyWiseStats();
        List<Placement>recentPlacements=placementRepository.findTop10ByOrderByPlacementDateDesc();
        List<Object[]>departmentStats=placementRepository.getDepartmentWiseStats();

        return new DashboardStatsDto(totalPlacements,companyStats,departmentStats,recentPlacements);
    }

    public List<Object[]>getDepartmentWiseStats()
    {
        return placementRepository.getDepartmentWiseStats();
    }

    public List<Placement>getPlacementsByDepartmentAndYear(String department,Integer year)
    {
        return placementRepository.findByStudentDepartmentAndStudentGraduationYear(department, year);
    }




}
