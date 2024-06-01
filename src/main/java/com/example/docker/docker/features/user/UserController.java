package com.example.docker.docker.features.user;

import com.example.docker.docker.features.errorscommon.GenericError;
import com.example.docker.docker.features.user.dto.CreateUserRequestV1;
import com.example.docker.docker.features.user.dto.UserDtoV1;
import com.example.docker.docker.features.user.dto.UserError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.vavr.control.Either;
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

    @Operation(summary = "Create a user with required data")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User created",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDtoV1.class))}
                    ),
                    @ApiResponse(
                            responseCode = "433",
                            description = "Impossible to parse date of birth"
                    )
            }
    )
    @PostMapping(path = "/users/add")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestV1 createUserRequest) {
        Either<GenericError, UserDtoV1> result = userService.createUser(createUserRequest);
        if (result.isLeft()) {
            return ResponseEntity.status(result.getLeft().getCode()).body(result.getLeft().getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(result.get());
        }
    }

    @Operation(summary = "Get all the users")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Users list",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDtoV1.class))}
                    )
            }
    )
    @GetMapping(path = "/users/getAll")
    public ResponseEntity<List<UserDtoV1>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @Operation(summary = "Delete a user through the id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "User with id:{userId} successfully deleted"
                            //content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDtoV1.class))}
                    ),
                    @ApiResponse(
                            responseCode = "419",
                            description = "Error while deleting user with id: {userId}"
                            //content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.UserGenericError.class))}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "User with id: {userId} not found"
                            //content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.UserGenericError.class))}
                    )
            }
    )
    @DeleteMapping(path = "/users/{userId}/delete")
    public ResponseEntity<?> deleteUser(
            @Parameter(description = "id of user to be deleted")
            @PathVariable("userId") String userId
    ) {
        Either<UserError, Boolean> result = userService.requestDeleteUser(Integer.parseInt(userId));

        if (result.isLeft()) {
            return ResponseEntity.status(result.getLeft().getCode()).body(result.getLeft().getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted user with id: " + userId);
        }
    }
}
