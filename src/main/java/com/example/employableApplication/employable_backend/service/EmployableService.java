package com.example.employableApplication.employable_backend.service;

import com.example.employableApplication.employable_backend.model.*;
import com.example.employableApplication.employable_backend.types.Sector;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;

public interface EmployableService extends UserDetailsService {
    public ArrayList<Job> listAllJobs();
    public ArrayList<Job> listAllJobsBySector(Sector sector);
    public ArrayList<Job> listAllJobsByWage(int salary);
    public Job addJob(Job job);
    public Application addApplication(Application application);
    public ArrayList<Application> viewApplicationByCandidateID(Long candidate_id);
    public ArrayList<Application> viewApplicationByJobID(Long job_id);
        public Application updateApplication(Application application);
    public Interview bookInterview(Interview interview);
    public Interview updateInterview(Interview interview);
    public Interview viewInterview(Long candidate_id,Long job_id);
    public Candidate addCandidate(Candidate candidate);
    public Employer addEmployer(Employer employer);
}
