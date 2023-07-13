package ua.com.alevel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> { }
