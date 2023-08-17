package ua.com.alevel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByFirstNameStartingWithIgnoreCaseOrLastNameEndingWithIgnoreCaseAndAgeBetween(String fn, String ln, int start, int end);
}
