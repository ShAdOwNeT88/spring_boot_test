package com.example.docker.docker.features.user.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;

public class UserDtoV1 {
    private int id;
    @NotBlank
    @Parameter(name = "email", description = "Email of the user", example = "prova@gmail.com")
    private String email;
    @NotBlank
    @Parameter(name = "name", description = "Name and surname of the user", example = "Mario Rossi")
    private String name;
    @NotBlank
    @Parameter(name = "dateOfBirth", description = "Date of birth of the user in ISO8601 format", example = "2024-05-31T12:10:48Z")
    private String dateOfBirth;
    @NotBlank
    @Parameter(name = "age", description = "Age of the user", example = "25")
    private long age;

    public UserDtoV1() {
    }

    public UserDtoV1(int id, String email, String name, String dateOfBirth, long age) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public UserDtoV1(String email, String name, String dateOfBirth, long age) {
        this.email = email;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public @NotBlank String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotBlank String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "UserDtoV1{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
