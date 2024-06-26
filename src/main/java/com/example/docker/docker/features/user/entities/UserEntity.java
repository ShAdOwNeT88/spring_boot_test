package com.example.docker.docker.features.user.entities;

import com.example.docker.docker.features.user.dto.UserDtoV1;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity(name = "User")
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "date_of_birth", nullable = false)
    private OffsetDateTime dateOfBirth;
    @Column(name = "age", nullable = false)
    private long age;

    public UserEntity() {
    }

    public UserEntity(String email, String name, OffsetDateTime dateOfBirth, long age) {
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

    public OffsetDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(OffsetDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserDtoV1 toDto() {
        return new UserDtoV1(this.id, this.email, this.name, this.dateOfBirth.toString(), this.age);
    }
}
