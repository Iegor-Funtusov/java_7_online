package ua.com.alevel.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.dto.EmployeeDto;
import ua.com.alevel.facade.EmployeeFacade;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class RestEmployeeController {

    @Autowired
    private EmployeeFacade employeeFacade;

    @GetMapping
    public ResponseEntity<Collection<EmployeeDto>> findAll(
            @RequestParam(required = false, name = "departmentId") Long departmentId,
            WebRequest webRequest) {
        Map<String, String[]> parameterMap = webRequest.getParameterMap();
        parameterMap.forEach((k,v) -> {
            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });
        if (departmentId != null) {
            return ResponseEntity.ok(employeeFacade.findAllEmployeesByDepartment(departmentId));
        }
        return ResponseEntity.ok(employeeFacade.findAll());
    }

    @PostMapping
    public ResponseEntity<Boolean> create(@RequestBody EmployeeDto dto) {
        employeeFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeFacade.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody EmployeeDto dto) {
        employeeFacade.update(id, dto);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        employeeFacade.delete(id);
        return ResponseEntity.ok(true);
    }
}
