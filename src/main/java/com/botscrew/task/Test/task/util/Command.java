package com.botscrew.task.Test.task.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Command {
    HEAD_OF_DEPARTMENT("Who is head of department (.+)", "departmentName"),
    DEPARTMENT_STATISTICS("Show (.+) statistics", "departmentName"),
    AVERAGE_SALARY("Show the average salary for the department (.+)", "departmentName"),
    EMPLOYEE_COUNT("Show count of employee for (.+)", "departmentName"),
    GLOBAL_SEARCH("Global search by (.+)", "template");

    private final Pattern pattern;
    private final String argumentName;

    Command(String regex, String argumentName) {
        this.pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        this.argumentName = argumentName;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public Map<String, String> getArguments(String input) {
        Map<String, String> arguments = new HashMap<>();
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                arguments.put(argumentName, matcher.group(i));
            }
        }
        return arguments;
    }

    public static Optional<Command> getCommandFromInput(String inputCommand) {
        for (Command command : Command.values()) {
            Pattern pattern = command.getPattern();
            Matcher matcher = pattern.matcher(inputCommand);
            if (matcher.matches()) {
                return Optional.of(command);
            }
        }

        return Optional.empty();
    }
}
