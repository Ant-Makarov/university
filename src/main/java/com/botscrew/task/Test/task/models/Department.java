package com.botscrew.task.Test.task.models;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "department")
@Getter
public class Department {

    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", columnDefinition = "varchar(255)", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_of_department", columnDefinition = "uuid", nullable = false)
    private Lector head;

    @ManyToMany(mappedBy = "departments")
    private List<Lector> lecturers;
}
