package com.botscrew.task.Test.task.services;

import com.botscrew.task.Test.task.exceptions.NoSuchDepartmentException;
import com.botscrew.task.Test.task.models.Department;
import com.botscrew.task.Test.task.models.Lector;
import com.botscrew.task.Test.task.repositories.DepartmentRepository;
import com.botscrew.task.Test.task.repositories.LectorRepository;
import com.botscrew.task.Test.task.repositories.UniversityDAO;
import com.botscrew.task.Test.task.util.Degree;
import jakarta.inject.Provider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UniversityService {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;
    private final UniversityDAO dao;
    private final Provider<StringBuilder> stringBuilderProvider;
    private final Clock clock;

    public String getHeadOfDepartment(Map<String, String> params) throws NoSuchDepartmentException {
        Department department = validateDepartment(params);
        Lector head = department.getHead();

        return stringBuilderProvider.get().append("Head of")
                                          .append(" ")
                                          .append(department.getName())
                                          .append(" ")
                                          .append("department is")
                                          .append(" ")
                                          .append(head.getName())
                                          .toString();
    }

    public String getStatistics(Map<String, String> params) throws NoSuchDepartmentException {
        Department department = validateDepartment(params);
        Map<Degree, Integer> statistics = dao.countLectorsByDegreeAndDepartmentName(department.getName());


        return stringBuilderProvider.get().append("ASSISTANTS - ")
                                          .append(statistics.get(Degree.ASSISTANT)).append("\n")
                                          .append("ASSOCIATE PROFESSORS - ")
                                          .append(statistics.get(Degree.ASSOCIATE_PROFESSOR)).append("\n")
                                          .append("PROFESSORS - ")
                                          .append(statistics.get(Degree.PROFESSOR)).toString();
    }

    public String getAverageSalary(Map<String, String> params) throws NoSuchDepartmentException {
        Department department = validateDepartment(params);
        BigDecimal avg = departmentRepository.getAverageSalaryByDepartmentName(department.getName());

        return stringBuilderProvider.get().append("The average salary of ")
                                          .append(department.getName())
                                          .append(" is ")
                                          .append(avg)
                                          .toString();
    }

    public String getEmployeeCount(Map<String, String> params) throws NoSuchDepartmentException {
        Department department = validateDepartment(params);

        int count = departmentRepository.countEmployeesByDepartmentName(department.getName());

        return stringBuilderProvider.get().append("Employee count: ").append(count).toString();
    }

    public String doGlobalSearch(Map<String, String> arguments) {
        String template = arguments.get("template");
        StringBuilder builder = stringBuilderProvider.get();
        List<Lector> lecturers = lectorRepository.globalSearchByTemplate(template);
        if (!lecturers.isEmpty()) {
            lecturers.forEach(lector -> builder.append(lector.getName()).append("; "));
        } else {
            builder.append("Nothing found by passed template :(");
        }

        return builder.toString();
    }
    private Department validateDepartment(Map<String, String> params) throws NoSuchDepartmentException {
        String departmentName = params.get("departmentName");

        return departmentRepository.findByName(departmentName.toUpperCase())
                .orElseThrow(() -> new NoSuchDepartmentException(String.format("Department %s not found", departmentName),
                                                                                                LocalDateTime.now(clock)));
    }
}
