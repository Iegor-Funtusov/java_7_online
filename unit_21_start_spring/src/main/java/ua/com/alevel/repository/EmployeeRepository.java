package ua.com.alevel.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.alevel.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {

    @Query("select e from Employee e where e.id not in (select e.id from Employee e join e.departments ed where ed.id = :depId)")
    List<Employee> findAllEmployeesByExcludeDepartment(@Param("depId") Long depId);

    @Query(value = "select e from Employee e join e.departments ed where ed.id = :depId")
    List<Employee> findAllEmployeesByDepartment(@Param("depId") Long depId);
}
