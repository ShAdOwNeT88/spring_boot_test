package com.example.docker.docker.features.user.dto;

import jakarta.validation.constraints.NotBlank;

public class UserDtoV1 {
    private int id;
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private int age;

    public UserDtoV1() {
    }

    public UserDtoV1(int id, String email, String name, int age) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.age = age;
    }

    public UserDtoV1(String email, String name, int age) {
        this.email = email;
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
