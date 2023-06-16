package ua.com.alevel.dictionary;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private String id;
    private String firstName;
    private String lastName;
    private int age;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

        if (age != student.age) return false;
        if (!Objects.equals(id, student.id)) return false;
        if (!Objects.equals(firstName, student.firstName)) return false;
        return Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int compareById = id.compareTo(o.getId());
        if (compareById == 0) {
            int compareByLastName = lastName.compareTo(o.getLastName());
            if (compareByLastName == 0) {
                return age - o.age;
            }
            return compareByLastName;
        }
        return id.compareTo(o.getId());
    }
}
