package com.example.docker.docker.features.errorscommon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericError {

    private int code;
    private String message;
}
