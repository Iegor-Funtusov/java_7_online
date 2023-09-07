package ua.com.alevel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.entity.Employee;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeDto extends BaseDto {

    private String firstName;
    private String lastName;
    private Integer age;
    private int countOfDepartments;

    public EmployeeDto(Employee employee) {
        super(employee);
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.age = employee.getAge();
        if (CollectionUtils.isNotEmpty(employee.getDepartments())) {
            this.countOfDepartments = employee.getDepartments().size();
        }
    }
}
