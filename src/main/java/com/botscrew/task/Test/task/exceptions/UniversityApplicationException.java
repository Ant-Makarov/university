package com.botscrew.task.Test.task.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UniversityApplicationException extends RuntimeException {

    private String message;

    private LocalDateTime dateTime;
}
