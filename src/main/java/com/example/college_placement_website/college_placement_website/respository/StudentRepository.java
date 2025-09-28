package com.example.college_placement_website.college_placement_website.respository;

import com.example.college_placement_website.college_placement_website.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

        Optional<Student>findByPrn(String PRN);
        List<Student>findByDepartmentAndGraduationYear(String department,Integer graduationYear);

        @Query("SELECT DISTINCT s.department FROM Student s ORDER BY s.department")
        List<String>findAllDepartments();

        @Query("SELECT DISTINCT s.graduationYear FROM Student s ORDER BY s.graduationYear")
        List<Integer>findAllGraduationYears();


}
