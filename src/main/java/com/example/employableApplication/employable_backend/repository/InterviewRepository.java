package com.example.employableApplication.employable_backend.repository;

import com.example.employableApplication.employable_backend.model.Interview;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends CrudRepository<Interview,Long> {
}
