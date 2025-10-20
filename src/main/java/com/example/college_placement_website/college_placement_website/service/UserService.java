package com.example.college_placement_website.college_placement_website.service;

import com.example.college_placement_website.college_placement_website.entity.Coordinator;
import com.example.college_placement_website.college_placement_website.entity.Faculty;
import com.example.college_placement_website.college_placement_website.respository.CoordinatorRepository;
import com.example.college_placement_website.college_placement_website.respository.FacultyRepository;
import com.example.college_placement_website.college_placement_website.respository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CoordinatorRepository coordinatorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserDetails result;
        Optional<Faculty>faculty=facultyRepository.findByUsername(username);
        if(faculty.isPresent())
        {
            Faculty f=faculty.get();
            result = User.builder()
                    .username(f.getUsername())
                    .password(f.getPassword())
                    .roles("FACULTY")
                    .build();
        } else {
            Optional<Coordinator>coordinator=coordinatorRepository.findByUsername(username);
            if(coordinator.isPresent())
            {
                Coordinator c=coordinator.get();
                result = User.builder()
                        .username(c.getUsername())
                        .password(c.getPassword())
                        .roles("COORDINATOR")
                        .build();
            } else {
                throw new UsernameNotFoundException("User not found: " + username);
            }
        }

        return result;
    }

    public Faculty saveFaculty(@org.jetbrains.annotations.NotNull Faculty faculty)
    {
        faculty.setPassword(passwordEncoder.encode(faculty.getPassword()));
        return facultyRepository.save(faculty);
    }

    public Coordinator saveCoordinator(Coordinator coordinator)
    {
        coordinator.setPassword(passwordEncoder.encode(coordinator.getPassword()));
        return coordinatorRepository.save(coordinator);
    }


}
