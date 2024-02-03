package com.example.docker.docker.features.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserResponse {
    String statusDescription;
    int statusCode;

    public UserResponse(String statusDescription, int statusCode) {
        this.statusDescription = statusDescription;
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static ResponseEntity<UserResponse> mapResponseEntity(UserResponse response) {
        HttpStatus status = HttpStatus.resolve(response.statusCode);
        if (status != null) {
            return new ResponseEntity<>(response, status);
        } else {
            return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
        }
    }

    static class UserSuccess extends UserResponse {
        User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public UserSuccess(String statusDescription, int statusCode, User usr) {
            super(statusDescription, statusCode);
            this.user = usr;
        }
    }

    static class UsersSuccess extends UserResponse {
        List<User> users;

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }

        public UsersSuccess(String statusDescription, int statusCode, List<User> usrs) {
            super(statusDescription, statusCode);
            this.users = usrs;
        }
    }

    static class UserDeletedSuccessfully extends UserResponse {
        public UserDeletedSuccessfully(String statusDescription, int statusCode) {
            super(statusDescription, statusCode);
        }
    }

    static class UserGenericError extends UserResponse {
        public UserGenericError(String statusDescription, int statusCode) {
            super(statusDescription, statusCode);
        }
    }
}
