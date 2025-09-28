package com.example.college_placement_website.college_placement_website.respository;

import com.example.college_placement_website.college_placement_website.entity.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoordinatorRepository extends JpaRepository<Coordinator,Long> {

    Optional<Coordinator>findByUserName(String username);
    Optional<Coordinator>findByEmail(String email);

}
