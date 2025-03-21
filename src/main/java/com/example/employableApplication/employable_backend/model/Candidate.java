package com.example.employableApplication.employable_backend.model;

import com.example.employableApplication.employable_backend.types.Education;
import com.example.employableApplication.employable_backend.types.Sector;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    String location;

    @Column
    LocalDate birthDate;

    @Column
    String emailAddress;

    @Enumerated(EnumType.STRING)
    @Column
    Sector sector;

    @Column
    List<String> skills;

    @Enumerated(EnumType.STRING)
    @Column
    Education education;

    @Column
    List<String> experience;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    List<Application> applications;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "job_id")
    Job job;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column
    String password;


}
