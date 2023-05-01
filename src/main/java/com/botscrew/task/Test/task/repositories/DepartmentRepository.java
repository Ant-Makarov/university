package com.botscrew.task.Test.task.repositories;

import com.botscrew.task.Test.task.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    Optional<Department> findByName(String departmentName);

    @Query("SELECT AVG(l.salary) FROM Department d JOIN d.lecturers l WHERE d.name = :departmentName")
    BigDecimal getAverageSalaryByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT COUNT(l) FROM Department d JOIN d.lecturers l WHERE d.name = :departmentName")
    int countEmployeesByDepartmentName(@Param("departmentName") String departmentName);
}
