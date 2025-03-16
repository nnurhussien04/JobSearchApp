package com.example.employableApplication.employable_backend.service;

import com.example.employableApplication.employable_backend.model.Application;
import com.example.employableApplication.employable_backend.model.Interview;
import com.example.employableApplication.employable_backend.model.Job;
import com.example.employableApplication.employable_backend.types.Sector;

import java.util.ArrayList;

public interface EmployableService {
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
}
