package com.example.docker.docker.features.user.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateUserRequestV1 {
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private int age;

    public CreateUserRequestV1() {
    }

    public CreateUserRequestV1(String email, String name, int age) {
        this.email = email;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
