package com.example.college_placement_website.college_placement_website.controller;

import com.example.college_placement_website.college_placement_website.dto.DashboardStatsDto;
import com.example.college_placement_website.college_placement_website.dto.PlacementStatsDto;
import com.example.college_placement_website.college_placement_website.respository.StudentRepository;
import com.example.college_placement_website.college_placement_website.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PublicController {

    @Autowired
    private PlacementService placementService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String dashboard(Model model)
    {
        DashboardStatsDto stats=placementService.getDashboardStats();
        model.addAttribute("stats",stats);
        model.addAttribute("departmentstats",placementService.getDepartmentWiseStats());
        model.addAttribute("departments",studentRepository.findAllDepartments());
        model.addAttribute("years",studentRepository.findAllGraduationYears());
        return "public/dashboard";
    }

    @GetMapping("/placements")
    public String viewPlacements(Model model,
                                 @RequestParam(required = false) String department,
                                 @RequestParam(required = false) Integer year)
    {
        if(department!=null && year!=null)
        {
            model.addAttribute("placements",placementService.getPlacementsByDepartmentAndYear(department, year));
            model.addAttribute("selectedDept",department);
            model.addAttribute("selectedYear",year);
        }
        else
        {
            model.addAttribute("placements",placementService.getAllPlacements());
        }

        model.addAttribute("departments",studentRepository.findAllDepartments());
        model.addAttribute("years",studentRepository.findAllGraduationYears());
        return "public/placements";

    }

    @GetMapping("/department-stats")
    public String departmentStats(@RequestParam String dept,@RequestParam Integer year, Model model)
    {
        PlacementStatsDto stats=placementService.getDepartmentStats(dept,year);
        model.addAttribute("stats",stats);
        model.addAttribute("department",dept);
        model.addAttribute("year",year);
        model.addAttribute("placements",placementService.getPlacementsByDepartmentAndYear(dept,year));
        return "public/department-stats";

    }

    @GetMapping("/login")
    public String login()
    {
        return "auth/login";
    }

}
