package model;

import java.time.LocalDate;

public class Employer {
    String firstName;

    String lastName;

    String phoneNumber;

    String birthDate;

    String emailAddress;

    String company;

    String role;

    String sector;

    String location;

    String username;

    String password;

    public Employer(String firstName, String lastName, String phoneNumber, String birthDate, String emailAddress, String company, String sector, String location, String role,String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.emailAddress = emailAddress;
        this.company = company;
        this.sector = sector;
        this.role = role;
        this.location = location;
        this.username = username;
        this.password = password;
    }

    public Employer() {
    }


}
