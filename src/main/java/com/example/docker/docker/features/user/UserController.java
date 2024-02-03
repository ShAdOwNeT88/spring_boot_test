package com.example.docker.docker.features.user;

import com.example.docker.docker.features.user.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(path = "/users/add")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserEntity userEntity) {
        UserEntity savedUserEntity = userRepository.save(userEntity);
        UserResponse.UserSuccess response = new UserResponse.UserSuccess("User saved successfully", savedUserEntity);
        return UserResponse.mapResponseEntity(response);
    }

    @GetMapping(path = "/users/getAll")
    public ResponseEntity<UserResponse> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        UserResponse.UsersSuccess response = new UserResponse.UsersSuccess("Users retrieved", userEntities);
        return UserResponse.mapResponseEntity(response);
    }

    @DeleteMapping(path = "/users/{userId}/delete")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable("userId") String userId) {
        boolean userExist = userRepository.existsById(Integer.valueOf(userId));
        if (userExist) {
            userRepository.deleteById(Integer.valueOf(userId));
            UserResponse.UserDeletedSuccessfully response =
                    new UserResponse.UserDeletedSuccessfully("Users with id: " + userId + " deleted");

            return UserResponse.mapResponseEntity(response);

        } else {
            UserResponse.UserGenericError response =
                    new UserResponse.UserGenericError("Error while deleting user with id: " + userId);

            return UserResponse.mapResponseEntity(response);

        }
    }
}
 
