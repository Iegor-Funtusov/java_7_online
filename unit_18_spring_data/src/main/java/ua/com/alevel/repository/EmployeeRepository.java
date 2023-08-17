package ua.com.alevel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.alevel.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByFirstNameStartingWithIgnoreCaseOrLastNameEndingWithIgnoreCaseAndAgeBetween(String fn, String ln, int start, int end);

    @Query("select e from Employee e where e.id not in (select e.id from Employee e join e.departments ed where ed.id = :depId)")
    List<Employee> findAllEmployeesByExcludeDepartment(@Param("depId") Long depId);

    @Query(value = "select * from employees as emp left join dep_emp as de on emp.id = de.emp_id where de.dep_id = ?", nativeQuery = true)
    List<Employee> findAllEmployeesByDepartment(Long depId);
}
