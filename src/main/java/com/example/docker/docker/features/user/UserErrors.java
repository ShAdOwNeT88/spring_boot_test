package com.example.docker.docker.features.user;


import com.example.docker.docker.features.errorscommon.GenericError;

public class UserErrors {

    public static class BirthdateEmptyOrNull extends GenericError {
        public BirthdateEmptyOrNull() {
            super(432, "birthdate empty or null");
        }
    }

    public static class ImpossibleToParseBirthdate extends GenericError {
        public ImpossibleToParseBirthdate() {
            super(433, "impossible to parse birthdate");
        }
    }

    public static class ImpossibleToDeleteUser extends GenericError {
        public ImpossibleToDeleteUser(Long userId, Exception e) {
            super(434, "impossible to delete user with id " + userId + " with error " + e.getMessage());
        }
    }

    public static class UserNotFound extends GenericError {
        public UserNotFound(Long userId) {
            super(435, "user with " + userId + " doesn't exist");
        }
    }

}
