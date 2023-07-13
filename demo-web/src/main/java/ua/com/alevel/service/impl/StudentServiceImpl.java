package ua.com.alevel.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.entity.Student;
import ua.com.alevel.repository.StudentRepository;
import ua.com.alevel.service.StudentService;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
