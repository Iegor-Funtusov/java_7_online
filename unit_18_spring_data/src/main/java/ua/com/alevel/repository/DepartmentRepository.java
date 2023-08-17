package ua.com.alevel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> { }
