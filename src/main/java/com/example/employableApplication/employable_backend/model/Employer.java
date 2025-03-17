package com.example.employableApplication.employable_backend.model;


import com.example.employableApplication.employable_backend.types.Sector;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="employer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employer {
    @Id
    @GeneratedValue
    @Column
    Long id;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    LocalDate birthDate;

    @Column
    String emailAddress;

    @Column
    String location;

    @Column
    String company;

    @Column
    String role;

    @Enumerated(EnumType.STRING)
    @Column
    Sector sector;

    @Column
    String username;

    @Column
    String password;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<Job> jobs;


    
}
