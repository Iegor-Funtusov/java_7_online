package ua.com.alevel;

import java.io.*;
import java.util.UUID;

public class SerialTest {

    private final Student student = generateStudent();

    public void serial() {
        System.out.println("SerialTest.serial");
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("student.txt"))) {
           outputStream.writeObject(student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deserial() {
        System.out.println("SerialTest.deserial");
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("student.txt"))) {
            Object o = inputStream.readObject();
            Student s = (Student) o;
            System.out.println("s = " + s);
        } catch (IOException e) {
            throw new RuntimeException();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        }
    }

    private static class Student implements Serializable {
        private String id;
        private String firstName;
        private String lastName;
        private transient String fullName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id='" + id + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", fullName='" + fullName + '\'' +
                    '}';
        }
    }

    private Student generateStudent() {
        Student temp = new Student();
        temp.setId(UUID.randomUUID().toString());
        temp.setFirstName("First");
        temp.setLastName("Last");
        temp.setFullName("First Last");
        return temp;
    }
}
