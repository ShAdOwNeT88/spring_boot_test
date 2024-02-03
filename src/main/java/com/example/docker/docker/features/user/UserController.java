package com.example.docker.docker.features.user;

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
    public ResponseEntity<UserResponse> createUser(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        UserResponse.UserSuccess response = new UserResponse.UserSuccess("User saved successfully", 201, savedUser);
        return UserResponse.mapResponseEntity(response);
    }

    @GetMapping(path = "/users/getAll")
    public ResponseEntity<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        UserResponse.UsersSuccess response = new UserResponse.UsersSuccess("Users retrieved", 200, users);
        return UserResponse.mapResponseEntity(response);
    }

    @DeleteMapping(path = "/users/{userId}/delete")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable("userId") String userId) {
        boolean userExist = userRepository.existsById(Integer.valueOf(userId));
        if (userExist) {
            userRepository.deleteById(Integer.valueOf(userId));
            UserResponse.UserDeletedSuccessfully response =
                    new UserResponse.UserDeletedSuccessfully("Users with id: " + userId + " deleted", 200);

            return UserResponse.mapResponseEntity(response);

        } else {
            UserResponse.UserGenericError response =
                    new UserResponse.UserGenericError("Error while deleting user with id: " + userId, 516);

            return UserResponse.mapResponseEntity(response);

        }
    }
}
 
