package com.allegra.employeemgrserver.domain.employee.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity // JPA to save to the database
@NoArgsConstructor // Non argument constructor
@RequiredArgsConstructor // creates parametrized constructor but you have to add args required which is NonNull
@Data //getters and Setters
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;


    public String toString() {
        return String.format("%d %s %s %s", id, firstName, lastName, email);
    }

}

