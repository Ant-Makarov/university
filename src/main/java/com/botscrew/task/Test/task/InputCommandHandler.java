package com.botscrew.task.Test.task;

import com.botscrew.task.Test.task.exceptions.UniversityApplicationException;
import com.botscrew.task.Test.task.services.UniversityService;
import com.botscrew.task.Test.task.util.Command;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class InputCommandHandler {

    private final Scanner scanner;

    private final UniversityService universityService;

    @Value("${context.menu}")
    private String contextMenu;

    @PostConstruct
    public void readCommand() {
        System.out.println("Hi there! I am a simple console app for university :)");
        while (true) {
            try {
                System.out.println(contextMenu);
                System.out.println(processCommand(scanner.nextLine()));
            } catch (NullPointerException e) {
                System.out.println("Input is incorrect. Please try again :)\n");
            }
        }
    }

    private String processCommand(String input) throws NullPointerException {
        Command command = Command.getCommandFromInput(input).orElseThrow(NullPointerException::new);
        String result;
        try {
            switch (command) {
                case HEAD_OF_DEPARTMENT -> result = universityService.getHeadOfDepartment(command.getArguments(input));
                case DEPARTMENT_STATISTICS -> result = universityService.getStatistics(command.getArguments(input));
                case AVERAGE_SALARY -> result = universityService.getAverageSalary(command.getArguments(input));
                case EMPLOYEE_COUNT -> result = universityService.getEmployeeCount(command.getArguments(input));
                case GLOBAL_SEARCH -> result = universityService.doGlobalSearch(command.getArguments(input));
                default -> result = "Unsupported operation";
            }
        } catch (UniversityApplicationException e) {
            result = e.getMessage();
        }

        return result;
    }
}

