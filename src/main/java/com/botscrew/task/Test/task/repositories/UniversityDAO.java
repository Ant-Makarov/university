package com.botscrew.task.Test.task.repositories;

import com.botscrew.task.Test.task.util.Degree;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UniversityDAO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public Map<Degree, Integer> countLectorsByDegreeAndDepartmentName(String departmentName) {
        String sql = " select l.degree, count(*) from lector l                 "
                   + " join lector_department ld using (lector_id)             "
                   + " join department d on ld.department_id = d.department_id "
                   + " where d.name = :departmentName                          "
                   + " group by l.degree                                       ";


        return jdbcTemplate.query(sql, Map.of("departmentName", departmentName), rs -> {
            Map<Degree, Integer> result = new HashMap<>();
            while (rs.next()) {
                result.put(Degree.valueOf(rs.getString("degree")), rs.getInt("count"));
            }
            return result;
        });
    }
}
