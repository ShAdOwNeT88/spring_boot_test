package com.example.docker.docker.features.user;

import com.example.docker.docker.features.user.dto.UserDtoV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    UserServiceV1 userService;

    @PostMapping(path = "/users/add")
    public ResponseEntity<UserDtoV1> createUser(@RequestBody UserDtoV1 userDtoV1) {
        UserDtoV1 savedUser = userService.createUser(userDtoV1);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping(path = "/users/getAll")
    public ResponseEntity<List<UserDtoV1>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{userId}/delete")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable("userId") String userId) {
        return userService.requestDeleteUser(Integer.valueOf(userId));
    }
}
 
