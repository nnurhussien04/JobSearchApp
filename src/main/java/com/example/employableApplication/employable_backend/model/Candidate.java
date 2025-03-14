package com.example.employableApplication.employable_backend.model;

import com.example.employableApplication.employable_backend.types.Education;
import com.example.employableApplication.employable_backend.types.Sector;
import jakarta.persistence.*;
import lombok.*;

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
    Date birthDate;

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

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private Set<Application> applications;


}
