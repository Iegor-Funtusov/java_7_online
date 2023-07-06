package ua.com.alevel.dao.impl;

import com.google.gson.Gson;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class JsonStudentDao implements StudentDao {

    private final List<Student> students = new ArrayList<>();

    @Override
    public void create(Student student) {
        readStudentsFromJson();
        student.setId(generateId());
        students.add(student);
        writeStudentsToJson();
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public Collection<Student> findAll() {
        readStudentsFromJson();
        return students;
    }

    @Override
    public boolean existById(String id) {
        return false;
    }

    private void readStudentsFromJson() {
        Gson gson = new Gson();
        try(FileReader fileReader = new FileReader("students.json")) {
            Student[] currentStudents = gson.fromJson(fileReader, Student[].class);
            if (currentStudents != null) {
                students.clear();
                students.addAll(Arrays.asList(currentStudents));
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void writeStudentsToJson() {
        Gson gson = new Gson();
        try(FileWriter fileWriter = new FileWriter("students.json")) {
            String json = gson.toJson(students);
            fileWriter.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private String generateId() {
        String id = UUID.randomUUID().toString();
        if (students.stream().anyMatch(student -> student.getId().equals(id))) {
            return generateId();
        }
        return id;
    }
}
