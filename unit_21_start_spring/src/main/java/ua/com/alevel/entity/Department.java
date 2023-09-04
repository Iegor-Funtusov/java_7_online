package ua.com.alevel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Department extends BaseEntity {

    private String name;

    @ManyToMany
    @JoinTable(
            name = "dep_emp",
            joinColumns = @JoinColumn(name = "dep_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id")
    )
    private Set<Employee> employees;
}
