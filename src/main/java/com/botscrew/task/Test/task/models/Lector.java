package com.botscrew.task.Test.task.models;

import com.botscrew.task.Test.task.util.Degree;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "lector")
@Check(constraints = "salary > 0.0")
@Getter
public class Lector {

    @Id
    @Column(name = "lector_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", columnDefinition = "varchar(100)", nullable = false)
    private String name;

    @Column(name = "degree", columnDefinition = "varchar(30)", nullable = false)
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @Column(name = "salary", columnDefinition = "numeric(7,2)", nullable = false)
    private BigDecimal salary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Lector_Department",
            joinColumns = @JoinColumn(name = "lector_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    private List<Department> departments;
}
