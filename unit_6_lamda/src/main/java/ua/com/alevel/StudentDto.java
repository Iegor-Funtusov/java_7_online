package ua.com.alevel;

// DTO
public class StudentDto {

    private String fullName;

    public StudentDto() {}

    public StudentDto(Student student) {
        this.setFullName(student.getFirstName() + " " + student.getLastName());
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
