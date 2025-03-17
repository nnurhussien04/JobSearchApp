package com.example.employableApplication.employable_backend.controller;

import com.example.employableApplication.employable_backend.model.Candidate;
import com.example.employableApplication.employable_backend.model.Employer;
import com.example.employableApplication.employable_backend.service.EmployableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ContentController {

    @Autowired
    EmployableService employableService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup/candidate")
    public String signupCandidate(){
        return "signup";
    }

    @GetMapping("/signup/employer")
    public String signupEmployer(){
        return "signup";
    }

    @PostMapping("/signup/candidate")
    public ResponseEntity<?> signUpCandidate(@RequestBody Candidate candidate){
        return new ResponseEntity<>(employableService.addCandidate(candidate), HttpStatus.OK);
    }

    @PostMapping("/signup/employer")
    public ResponseEntity<?> signUpEmployer(@RequestBody Employer employer){
        return new ResponseEntity<>(employableService.addEmployer(employer),HttpStatus.OK);
    }

}
