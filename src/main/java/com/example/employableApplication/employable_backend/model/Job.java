package com.example.employableApplication.employable_backend.model;

import com.example.employableApplication.employable_backend.types.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "job")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {

    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    String jobRole;

    @Column
    String jobType;

    @Column
    Sector jobSector;

    @Column
    String location;

    @Column
    int salary;

    @Column
    String description;

    @Column
    String benefits;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    List<Candidate> candidate;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    Employer employer;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private Set<Application> applications;



}
