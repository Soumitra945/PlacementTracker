package com.example.college_placement_website.college_placement_website.respository;

import com.example.college_placement_website.college_placement_website.entity.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlacementRepository extends JpaRepository<Placement,Long> {

    List<Placement> findByStudentDepartmentAndStudentGraduationYear(String department,Integer Year);

    @Query("SELECT COUNT(p) FROM Placement p WHERE p.student.department=:department AND p.student.graduationYear=:graduationYear")
    Long countByDepartmentAndYear(@Param("department") String department, @Param("graduationYear") Integer Year);

    @Query("SELECT AVG(p.ctcAmount) FROM Placement p WHERE p.student.department=:department AND p.student.graduationYear=:year")
    Double getAverageCTCByDepartmentAndGraduationUYear(@Param("department")String department,@Param("graduationYear") Integer Year);

    @Query("SELECT MAX(p.ctcAmount) FROM Placement p WHERE p.student.department=:department AND p.student.graduationYear=:year")
    Double getMaxCTCByDepartmentAndGraduationYear(@Param("department") String department,@Param("graduationYear") Integer year);

    @Query("SELECT MAX(p.ctcAmount) FROM Placement p")
    Double getMaxCTC();

    @Query("SELECT AVG(p.ctcAmount) FROM Placement p")
    Double getAvgCTC();

    @Query("SELECT p.company.companyName,COUNT(p) FROM Placement p GROUP BY p.company.companyName ORDER BY COUNT(p) DESC")
    List<Object[]>getCompanyWiseStats();

    @Query("SELECT p.student.department,COUNT(p) FROM Placement p GROUP BY p.student.department ORDER BY COUNT(p) DESC")
    List<Object[]>getDepartmentWiseStats();

    List<Placement>findTop10ByOrderByPlacementDateDesc();

    @Query("SELECT COUNT(p) FROM Placement p WHERE p.student.department=:department")
    Long countByDepartment(@Param("department") String department);





}
