package com.example.docker.docker.features.user;

import com.example.docker.docker.features.user.entities.UserEntity;
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
        UserEntity userEntity;

        public UserEntity getUser() {
            return userEntity;
        }

        public void setUser(UserEntity userEntity) {
            this.userEntity = userEntity;
        }

        public UserSuccess(String statusDescription, UserEntity usr) {
            super(statusDescription, HttpStatus.OK.value());
            this.userEntity = usr;
        }
    }

    static class UsersSuccess extends UserResponse {
        List<UserEntity> userEntities;

        public List<UserEntity> getUsers() {
            return userEntities;
        }

        public void setUsers(List<UserEntity> userEntities) {
            this.userEntities = userEntities;
        }

        public UsersSuccess(String statusDescription, List<UserEntity> usrs) {
            super(statusDescription, HttpStatus.OK.value());
            this.userEntities = usrs;
        }
    }

    static class UserDeletedSuccessfully extends UserResponse {
        public UserDeletedSuccessfully(String statusDescription) {
            super(statusDescription, HttpStatus.NO_CONTENT.value());
        }
    }

    static class UserGenericError extends UserResponse {
        public UserGenericError(String statusDescription) {
            super(statusDescription, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
