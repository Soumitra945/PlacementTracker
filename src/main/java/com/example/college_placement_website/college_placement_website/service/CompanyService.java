package com.example.college_placement_website.college_placement_website.service;

import com.example.college_placement_website.college_placement_website.entity.Company;
import com.example.college_placement_website.college_placement_website.respository.CompanyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRespository companyRespository;

    public List<Company> getAllCompanies()
    {
        return companyRespository.findAll();
    }

    public Optional<Company> getCompanyById(Long id)
    {
        return companyRespository.findById(id);
    }

    public Optional<Company> getCompanyByName(String name)
    {
        return companyRespository.findBycompanyName(name);
    }

    public Company saveCompany(Company company)
    {
        return companyRespository.save(company);
    }

    public void deleteCompany(Long id)
    {
        companyRespository.deleteById(id);
    }

}
