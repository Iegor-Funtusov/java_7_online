package ua.com.alevel.entity;

public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private int age;
    String email;

    public Student() { }

    // overloading
    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void student() { }

    private void test() {
        String firstName = "";
        System.out.println("firstName = " + firstName);
        System.out.println("firstName = " + this.firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    // overloading
    public void setFirstName(final String firstName, int age) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
