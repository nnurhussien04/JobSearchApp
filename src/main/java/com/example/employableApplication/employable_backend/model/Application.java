package com.example.employableApplication.employable_backend.model;

import com.example.employableApplication.employable_backend.types.Outcome;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.util.Set;

import static com.example.employableApplication.employable_backend.types.Outcome.PENDING;

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

    @Enumerated(EnumType.STRING)
    @ColumnDefault("PENDING")
    Outcome outcome;

}
