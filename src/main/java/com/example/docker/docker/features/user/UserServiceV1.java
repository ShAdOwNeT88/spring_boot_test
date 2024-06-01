package com.example.docker.docker.features.user;

import com.example.docker.docker.features.errorscommon.GenericError;
import com.example.docker.docker.features.user.dto.CreateUserRequestV1;
import com.example.docker.docker.features.user.dto.UserDtoV1;
import com.example.docker.docker.features.user.dto.UserError;
import com.example.docker.docker.features.user.entities.UserEntity;
import io.vavr.control.Either;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceV1 {

    @Autowired
    UserRepository userRepository;

    Either<GenericError, UserDtoV1> createUser(CreateUserRequestV1 userCreationRequest) {
        OffsetDateTime dob;
        try {
            dob = OffsetDateTime.parse(userCreationRequest.getDateOfBirth());
            long calculatedAge = ChronoUnit.YEARS.between(dob, OffsetDateTime.now());
            UserEntity userToSave = new UserEntity(userCreationRequest.getEmail(), userCreationRequest.getName(), dob, calculatedAge);
            UserEntity savedUserEntity = userRepository.save(userToSave);
            return Either.right(savedUserEntity.toDto());
        } catch (DateTimeParseException ex) {
            return Either.left(new UserErrors.ImpossibleToParseBirthdate());
        }
    }

    Either<UserError, Boolean> requestDeleteUser(int userId) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            try {
                userRepository.deleteById(userId);
                return Either.right(true);
            } catch (Exception ex) {
                return Either.left(
                        new UserError(
                                419,
                                "Error while deleting user with id: " + userId + " with error: " + ex.getMessage())
                );
            }
        } else {
            return Either.left(
                    new UserError(
                            404,
                            "User with id: " + userId + " not found"
                    )
            );
        }
    }

    List<UserDtoV1> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(UserEntity::toDto).toList();
    }
}
