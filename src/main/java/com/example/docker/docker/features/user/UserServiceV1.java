package com.example.docker.docker.features.user;

import com.example.docker.docker.features.user.dto.UserDtoV1;
import com.example.docker.docker.features.user.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    @Autowired
    UserRepository userRepository;

    UserDtoV1 createUser(UserDtoV1 userCreationRequest) {
        UserEntity userToSave = new UserEntity(userCreationRequest.getEmail(), userCreationRequest.getName(), userCreationRequest.getAge());
        UserEntity savedUserEntity = userRepository.save(userToSave);
        return savedUserEntity.toDto();
    }

    ResponseEntity<UserResponse> requestDeleteUser(int userId) {
        boolean userExist = userRepository.existsById(userId);
        if (userExist) {
            userRepository.deleteById(userId);
            UserResponse.UserDeletedSuccessfully response =
                    new UserResponse.UserDeletedSuccessfully("Users with id: " + userId + " deleted");

            return UserResponse.mapResponseEntity(response);

        } else {
            UserResponse.UserGenericError response =
                    new UserResponse.UserGenericError("Error while deleting user with id: " + userId);

            return UserResponse.mapResponseEntity(response);

        }
    }

    List<UserDtoV1> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(UserEntity::toDto).toList();
    }
}
