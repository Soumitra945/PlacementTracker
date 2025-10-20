package com.example.college_placement_website.college_placement_website.controller;

import com.example.college_placement_website.college_placement_website.entity.Company;
import com.example.college_placement_website.college_placement_website.entity.Placement;
import com.example.college_placement_website.college_placement_website.entity.Student;
import com.example.college_placement_website.college_placement_website.respository.StudentRepository;
import com.example.college_placement_website.college_placement_website.service.CompanyService;
import com.example.college_placement_website.college_placement_website.service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAnyRole('FACULTY', 'TPO_COORDINATOR')")
public class AdminController {

    @Autowired
    private PlacementService placementService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/dashboard")
    public String adminDashboard(Model model, Authentication auth)
    {
        model.addAttribute("stats",placementService.getDashboardStats());
        model.addAttribute("user",auth.getName());
        model.addAttribute("role",auth.getAuthorities().toString());
        model.addAttribute("departmentstats",placementService.getDepartmentWiseStats());
        return "/admin/dashboard";
    }

    @GetMapping("/add-placement")
    public String addPlacementForm(Model model)
    {
        model.addAttribute("placement",new Placement());
        model.addAttribute("companies",companyService.getAllCompanies());
        model.addAttribute("student",studentRepository.findAll());
        return "admin/add-placement";
    }

    @PostMapping("/add-placement")
    public String savePlacement(@ModelAttribute Placement placement, RedirectAttributes redirectAttributes)
    {
        try{
            placementService.savePlacement(placement);
            redirectAttributes.addFlashAttribute("sucess", "Placement added sucessfully");
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("error","Error adding placement: " +e.getMessage());
        }

        return "redirect:/admin/dashboard";
    }

    @GetMapping("/manage-placements")
    public String managePlacements(Model model)
    {
        model.addAttribute("placements",placementService.getAllPlacements());
        return "admin/manage-placements";
    }

    @GetMapping("/add-company")
    public String addCompanyForm(Model model)
    {
        model.addAttribute("company",new Company());
        return "admin/add-company";
    }

    @PostMapping("/add-company")
    public String saveCompanyForm(@ModelAttribute Company company,RedirectAttributes redirectAttributes)
    {
        try{
            companyService.saveCompany(company);
            redirectAttributes.addFlashAttribute("success","Company added successfully");
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("error","Error saving company: "+e.getMessage());
        }

        return "redirect:/admin/dashboard";
    }

    @GetMapping("/add-student")
    public String addStudentForm(Model model)
    {
        model.addAttribute("student",new Student());
        return "admin/add-student";
    }

    @PostMapping("/add-student")
    public String saveStudentForm(@ModelAttribute Student student,RedirectAttributes redirectAttributes)
    {
        try{
            studentRepository.save(student);
            redirectAttributes.addFlashAttribute("sucess","Student saved successfully");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("error","Error saving student: "+e.getMessage());
        }

        return "redirect:/admin/dashboard";

    }

    @PostMapping("delete-placement/{id}")
    @PreAuthorize("hasRole('FACULTY')")
    public String deletePlacement(@PathVariable Long id,RedirectAttributes redirectAttributes)
    {
        try{
            placementService.deletePlacement(id);
            redirectAttributes.addFlashAttribute("sucess","Placement deleted successfully");
        }
        catch(Exception e){
            redirectAttributes.addFlashAttribute("error","Error while deleting placement: "+e.getMessage());
        }

        return "redirect:/admin/dashboard";
    }





}
