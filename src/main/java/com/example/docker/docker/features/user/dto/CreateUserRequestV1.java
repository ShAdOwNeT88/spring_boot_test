package com.example.docker.docker.features.user.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;

public class CreateUserRequestV1 {
    @NotBlank
    @Parameter(name = "email", description = "Email of the user", example = "prova@gmail.com")
    private String email;
    @NotBlank
    @Parameter(name = "name", description = "Name and surname of the user", example = "Mario Rossi")
    private String name;
    @NotBlank
    @Parameter(name = "dateOfBirth", description = "Date of birth of the user in ISO8601 format", example = "2024-05-31T12:10:48Z")
    private String dateOfBirth;

    public CreateUserRequestV1() {
    }

    public CreateUserRequestV1(String email, String name, String dateOfBirth) {
        this.email = email;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "CreateUserRequestV1{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
