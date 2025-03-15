package com.example.employableApplication.employable_backend.repository;

import com.example.employableApplication.employable_backend.model.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends CrudRepository<Employer,Long> {
}
