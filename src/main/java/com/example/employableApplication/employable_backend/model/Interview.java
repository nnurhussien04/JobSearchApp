package com.example.employableApplication.employable_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Entity
@Table(name="interview")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Interview {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @OneToOne
    @JoinColumn(name = "job_id")
    Job job;

    @OneToOne
    @JoinColumn(name="candidate_id")
    Candidate candidate;

    @Column
    LocalDate interviewDate;

    @Column
    LocalTime interviewTime;

    @Column
    String interviewLocation;
}
