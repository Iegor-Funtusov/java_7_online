package ua.com.alevel;

import java.util.ArrayList;
import java.util.List;

public class AnonimTest {

    public void test() {
        IAnonim iAnonim = new IAnonimImpl();
        int sum = iAnonim.sum(10, 7);
        System.out.println("sum = " + sum);

        IAnonim iAnonim1 = new IAnonim() {  // abstract class or interface class implementation without name
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        sum = iAnonim1.sum(23, 78);
        System.out.println("sum = " + sum);

        IAnonim iAnonim2 = (a, b) -> a + b;  // lambda
        sum = iAnonim2.sum(12, 6);
        System.out.println("sum = " + sum);

//        lambda == anonim class
//        anonim class != lambda

        IAnonim iAnonim3 = this::sum1; // 1 link to current method
        sum = iAnonim3.sum(13, 6);
        System.out.println("sum = " + sum);

        IAnonim iAnonim4 = IntegerTest::sum; // 2 link to static method of some class
        sum = iAnonim4.sum(13, 7);
        System.out.println("sum = " + sum);

        IntegerTest integerTest = new IntegerTest();
        IAnonim iAnonim5 = integerTest::sumsum; // 3 link to method of variable
        sum = iAnonim5.sum(13, 7);
        System.out.println("sum = " + sum);

        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setFirstName("Petro");
        student1.setLastName("Petrenko");

        Student student2 = new Student();
        student2.setFirstName("Maksim");
        student2.setLastName("Maksimenko");

        students.add(student1);
        students.add(student2);

        List<StudentDto> studentDtos = new ArrayList<>();

        for (Student student : students) {
            StudentDto studentDto = new StudentDto();
            studentDto.setFullName(student.getFirstName() + " " + student.getLastName());
            studentDtos.add(studentDto);
        }
        System.out.println("studentDtos = " + studentDtos);

        studentDtos.clear();

        for (Student student : students) {
            StudentDto studentDto = new StudentDto(student);
            studentDtos.add(studentDto);
        }
        System.out.println("studentDtos = " + studentDtos);

        studentDtos.clear();

        studentDtos = students // 4 link to constructor
                .stream()
                .map(StudentDto::new)
                .toList();
        System.out.println("studentDtos = " + studentDtos);
    }

    private int sum1(int a, int b) {
        return a + b;
    }

    private static IAnonim getIAnonim() {
        return new IAnonim() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
    }
}
