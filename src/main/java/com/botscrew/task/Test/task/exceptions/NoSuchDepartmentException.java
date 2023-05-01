package com.botscrew.task.Test.task.exceptions;

import java.time.LocalDateTime;

public class NoSuchDepartmentException extends UniversityApplicationException {
    public NoSuchDepartmentException(String message, LocalDateTime dateTime) {
        super(message, dateTime);
    }
}
