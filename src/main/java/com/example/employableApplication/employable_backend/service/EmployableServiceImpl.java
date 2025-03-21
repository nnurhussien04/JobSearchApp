package com.example.employableApplication.employable_backend.service;

import com.example.employableApplication.employable_backend.model.*;
import com.example.employableApplication.employable_backend.repository.*;
import com.example.employableApplication.employable_backend.types.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.employableApplication.employable_backend.security.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

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

    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;

    @Override
    public ArrayList<Job> listAllJobs(){
        ArrayList<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(jobs::add);

        return jobs;
    }

    @Override
    public ArrayList<Job> listAllJobsBySector(Sector sector){
        ArrayList<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(x -> {
            if(x.getJobSector().equals(sector)){
                jobs.add(x);
            }
        });
        return jobs;
    }

    @Override
    public ArrayList<Job> listAllJobsByWage(int salary){
        ArrayList<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(x -> {
            if(x.getSalary() <= salary){
                jobs.add(x);
            }
        });
        return jobs;
    }

    @Override
    public Job addJob(Job job){
        if(job.getJobSector() == null || job.getSalary() < 0 || job.getJobType().isEmpty() || job.getJobRole().isEmpty() || job.getBenefits() == null || job.getLocation() == null || job.getDescription() == null){
            throw new NullPointerException();
        }
        return jobRepository.save(job);
    }

    @Override
    public Application addApplication(Application application){
        if(application.getJob() == null || application.getCandidate() == null){
            throw new NullPointerException();
        }
        return applicationRepository.save(application);
    }

    @Override
    public ArrayList<Application> viewApplicationByCandidateID(Long candidate_id){
        ArrayList<Application> applications = new ArrayList<>();
        applicationRepository.findAll().forEach(x -> {
            if(Objects.equals(x.getCandidate().getId(), candidate_id)){
                applications.add(x);
            }
        });
        return applications;
    }

    @Override
    public ArrayList<Application> viewApplicationByJobID(Long job_id){
        ArrayList<Application> applications = new ArrayList<>();
        applicationRepository.findAll().forEach(x -> {
            if(Objects.equals(x.getJob().getId(), job_id)){
                applications.add(x);
            }
        });
        return applications;
    }

    @Override
    public Application updateApplication(Application application) {
        if(application.getCandidate() == null || application.getJob() == null || application.getId() == null){
            throw new NullPointerException();
        }
        Application newApplication = new Application();
        newApplication.setId(application.getId());
        newApplication.setJob(application.getJob());
        newApplication.setCandidate(application.getCandidate());
        newApplication.setOutcome(application.getOutcome());
        return applicationRepository.save(newApplication);
    }

    @Override
    public Interview bookInterview(Interview interview){
        if(interview.getCandidate() == null || interview.getJob() == null || interview.getInterviewDate() == null || interview.getInterviewTime() == null){
            throw new NullPointerException();
        }
        return interviewRepository.save(interview);
    }

    @Override
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

    @Override
    public Interview viewInterview(Long candidate_id, Long job_id) {
        ArrayList<Interview> interview = new ArrayList<>();
        interviewRepository.findAll().forEach( x -> {
            if(x.getJob().getId().equals(job_id) && x.getCandidate().getId().equals(candidate_id)){
                interview.add(x);
            }
        });
        if(interview.size() == 0){
            return null;
        }
        return interview.get(0);
    }

    @Override
    public Candidate addCandidate(Candidate candidate){
        if(candidate.getLocation() == null || candidate.getBirthDate() == null || candidate.getLocation() == null || candidate.getEducation() == null || candidate.getExperience() == null || candidate.getFirstName() == null || candidate.getLastName() == null || candidate.getSector() == null || candidate.getSkills() == null){
            throw new NullPointerException();
        }

        if(candidateRepository.findByUsername(candidate.getUsername()).isPresent()){
            throw new RuntimeException();
        }

        candidate.setPassword(passwordEncoder.encode(candidate.getPassword()));
        return candidateRepository.save(candidate);
    }

    @Override
    public Employer addEmployer(Employer employer){
        if(employer.getBirthDate() == null || employer.getSector() == null || employer.getFirstName() == null || employer.getLastName() == null || employer.getLocation() == null || employer.getCompany() == null || employer.getEmailAddress() == null || employer.getUsername() == null || employer.getPassword() == null || employer.getRole() == null){
            throw new NullPointerException();
        }

        if(employerRepository.findByUsername(employer.getUsername()).isPresent()){
            throw new RuntimeException();
        }

        employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        return employerRepository.save(employer);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employer> employer = employerRepository.findByUsername(username);
        Optional<Candidate> candidate = candidateRepository.findByUsername(username);
        if(employer.isPresent()){
            var userObj = employer.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }
        else if(candidate.isPresent()){
            var userObj = candidate.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }
    }
}
