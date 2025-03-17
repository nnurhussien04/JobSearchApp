package com.example.employableApplication.employable_backend.repository;

import com.example.employableApplication.employable_backend.model.Candidate;
import com.example.employableApplication.employable_backend.model.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends CrudRepository<Employer,Long> {
    Optional<Employer> findByUsername(String username);
}
