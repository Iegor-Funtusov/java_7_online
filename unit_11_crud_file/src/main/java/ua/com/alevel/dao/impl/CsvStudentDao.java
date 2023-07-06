package ua.com.alevel.dao.impl;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class CsvStudentDao implements StudentDao {

    private final List<Student> students = new ArrayList<>();

    @Override
    public void create(Student student) {
        readStudentsFromCsv();
        student.setId(generateId());
        students.add(student);
        writeStudentsToCsv();
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
        readStudentsFromCsv();
        return students;
    }

    @Override
    public boolean existById(String id) {
        return false;
    }

    private void readStudentsFromCsv() {
        try(CSVReader csvReader = new CSVReader(new FileReader("students.csv"))) {
            List<String[]> list = csvReader.readAll();
            students.clear();
            if (CollectionUtils.isNotEmpty(list)) {
                for (String[] strings : list) {
                    Student student = new Student();
                    student.setId(strings[0]);
                    student.setFirstName(strings[1]);
                    student.setLastName(strings[2]);
                    student.setAge(Integer.parseInt(strings[3]));
                    students.add(student);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void writeStudentsToCsv() {
        try(CSVWriter csvWriter = new CSVWriter(new FileWriter("students.csv"))) {
            List<String[]> list = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(students)) {
                for (Student student : students) {
                    String[] strings = new String[] {
                            student.getId(),
                            student.getFirstName(),
                            student.getLastName(),
                            String.valueOf(student.getAge())
                    };
                    list.add(strings);
                }
                csvWriter.writeAll(list);
            }
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
