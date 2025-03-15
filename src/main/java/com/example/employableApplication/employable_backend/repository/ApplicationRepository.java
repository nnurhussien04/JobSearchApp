package com.example.employableApplication.employable_backend.repository;

import com.example.employableApplication.employable_backend.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends CrudRepository<Application,Long> {

}
