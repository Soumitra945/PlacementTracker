package com.example.college_placement_website.college_placement_website.respository;


import com.example.college_placement_website.college_placement_website.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {

    Optional<Faculty>findByUserName(String username);
    Optional<Faculty>findByFullName(String fullName);
    Optional<Faculty>findByEmail(String email);

}
