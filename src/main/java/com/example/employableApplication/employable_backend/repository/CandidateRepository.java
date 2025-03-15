package com.example.employableApplication.employable_backend.repository;


import com.example.employableApplication.employable_backend.model.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate,Long> {

}
