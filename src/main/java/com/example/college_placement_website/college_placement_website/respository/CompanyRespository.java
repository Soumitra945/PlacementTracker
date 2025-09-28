package com.example.college_placement_website.college_placement_website.respository;


import com.example.college_placement_website.college_placement_website.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRespository extends JpaRepository<Company,Long> {

    Optional<Company>findByCompanyName(String companyName);
    Optional<Company>findByIndustry(String Industry);


}
