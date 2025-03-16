package com.example.employableApplication.employable_backend.controller;


import com.example.employableApplication.employable_backend.model.Application;
import com.example.employableApplication.employable_backend.model.Interview;
import com.example.employableApplication.employable_backend.model.Job;
import com.example.employableApplication.employable_backend.service.EmployableService;
import com.example.employableApplication.employable_backend.types.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employable")
public class EmployableController {

    @Autowired
    private EmployableService employableService;

    @GetMapping("/jobs")
    public ResponseEntity<?> viewJobs(){
        return new ResponseEntity<>(employableService.listAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/jobs")
    public ResponseEntity<?> viewJobsBySector(@RequestParam("sector") Sector sector){
        return new ResponseEntity<>(employableService.listAllJobsBySector(sector),HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<?> addJobs(@RequestBody Job job){
        return new ResponseEntity<>(employableService.addJob(job),HttpStatus.CREATED);
    }

    @PostMapping("/application")
    public ResponseEntity<?> addApplication(@RequestBody Application application){
        return new ResponseEntity<>(employableService.addApplication(application),HttpStatus.CREATED);
    }

    @GetMapping("/application/candidate")
    public ResponseEntity<?> viewApplicationByCandidateID(@RequestParam("candidate_id") Long candidate_id){
        return new ResponseEntity<>(employableService.viewApplicationByCandidateID(candidate_id), HttpStatus.OK);
    }

    @GetMapping("/application/job")
    public ResponseEntity<?> viewApplicationByJobID(@RequestParam("job_id") Long jobID){
        return new ResponseEntity<>(employableService.viewApplicationByJobID(jobID),HttpStatus.OK);
    }

    @PutMapping("/application")
    public ResponseEntity<?> updateApplication(@RequestBody Application application){
        return new ResponseEntity<>(employableService.updateApplication(application),HttpStatus.ACCEPTED)
    }

    @PostMapping("/interview")
    public ResponseEntity<?> bookInterview(@RequestBody Interview interview){
        return new ResponseEntity<>(employableService.bookInterview(interview),HttpStatus.CREATED);
    }

    @PutMapping("/interview")
    public ResponseEntity<?> updateInterview(@RequestBody Interview interview){
        return new ResponseEntity<>(employableService.updateInterview(interview),HttpStatus.ACCEPTED)
    }














}
