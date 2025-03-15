package com.example.employableApplication.employable_backend.repository;

import com.example.employableApplication.employable_backend.model.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends CrudRepository<Job,Long> {

}
