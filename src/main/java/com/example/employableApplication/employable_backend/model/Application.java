package com.example.employableApplication.employable_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="application")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Application {

    @GeneratedValue
    @Id
    @Column
    Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column
    boolean outcome;

}
