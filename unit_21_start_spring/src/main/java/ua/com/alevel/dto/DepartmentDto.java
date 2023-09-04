package ua.com.alevel.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.entity.Department;

@Getter
@Setter
@NoArgsConstructor
public class DepartmentDto extends BaseDto {

    private String name;
    private int countOfEmployees;

    public DepartmentDto(Department department) {
        super(department);
        this.name = department.getName();
        if (CollectionUtils.isNotEmpty(department.getEmployees())) {
            this.countOfEmployees = department.getEmployees().size();
        }
    }
}
