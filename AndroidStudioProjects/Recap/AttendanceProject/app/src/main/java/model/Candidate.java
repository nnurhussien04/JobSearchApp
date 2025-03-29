package model;

import java.time.LocalDate;

public class Candidate {
    String firstName;

    String lastName;

    String phoneNumber;

    String birthDate;

    String emailAddress;
    String sector;

    String[] skills;

    String education;

    String[] experience;

    String username;

    String password;

    public Candidate(String firstName, String lastName, String phoneNumber, String birthDate, String emailAddress, String sector, String[] skills, String education, String[] experience, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
        this.sector = sector;
        this.skills = skills;
        this.education = education;
        this.experience = experience;
        this.username = username;
        this.password = password;
    }

    public Candidate() {
    }

}
