package com.example.employableApplication.employable_backend.service;

import com.example.employableApplication.employable_backend.model.Application;
import com.example.employableApplication.employable_backend.model.Interview;
import com.example.employableApplication.employable_backend.model.Job;
import com.example.employableApplication.employable_backend.repository.*;
import com.example.employableApplication.employable_backend.types.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class EmployableServiceImpl implements EmployableService{

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    EmployerRepository employerRepository;

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    JobRepository jobRepository;

    public ArrayList<Job> listAllJobs(){
        ArrayList<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(jobs::add);
        return jobs;
    }

    public ArrayList<Job> listAllJobsBySector(Sector sector){
        ArrayList<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(x -> {
            if(x.getJobSector().equals(sector)){
                jobs.add(x);
            }
        });
        return jobs;
    }

    public ArrayList<Job> listAllJobsByWage(int salary){
        ArrayList<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(x -> {
            if(x.getSalary() <= salary){
                jobs.add(x);
            }
        });
        return jobs;
    }

    public Job addJob(Job job){
        if(job.getJobSector() != null || job.getSalary() < 0 || job.getEmployer() == null || job.getJobType().isEmpty() || job.getJobRole().isEmpty() || job.getBenefits() == null || job.getLocation() == null || job.getDescription() == null){
            throw new NullPointerException();
        }
        return jobRepository.save(job);
    }

    public Application addApplication(Application application){
        if(application.getJob() == null || application.getCandidate() == null){
            throw new NullPointerException();
        }
        return applicationRepository.save(application);
    }

    public ArrayList<Application> viewApplication(Long candidate_id){
        ArrayList<Application> applications = new ArrayList<>();
        applicationRepository.findAll().forEach(x -> {
            if(Objects.equals(x.getCandidate().getId(), candidate_id)){
                applications.add(x);
            }
        });
        return applications;
    }

    public Application updateApplication(Application application){
        if(application.getCandidate() == null || application.getJob() == null || application.getId() == null){
            throw new NullPointerException();
        }
        Application newApplication = new Application();
        newApplication.setId(application.getId());
        newApplication.setJob(application.getJob());
        newApplication.setCandidate(application.getCandidate());
        newApplication.setOutcome(application.isOutcome());
        return applicationRepository.save(newApplication);
    }

    public Interview bookInterview(Interview interview){
        if(interview.getCandidate() == null || interview.getJob() == null || interview.getInterviewDate() == null || interview.getInterviewTime() == null){
            throw new NullPointerException();
        }
        return interviewRepository.save(interview);
    }

    public Interview updateInterview(Interview interview){
        Interview newInterview = new Interview();
        if(interview.getCandidate() == null || interview.getJob() == null || interview.getInterviewDate() == null || interview.getInterviewTime() == null){
            throw new NullPointerException();
        }
        newInterview.setId(interview.getId());
        newInterview.setJob(interview.getJob());
        newInterview.setCandidate(interview.getCandidate());
        newInterview.setInterviewDate(interview.getInterviewDate());
        newInterview.setInterviewTime(interview.getInterviewTime());
        newInterview.setInterviewLocation(interview.getInterviewLocation());
        return interviewRepository.save(newInterview);
    }









    







}
