package ua.com.alevel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.EmployeeDto;
import ua.com.alevel.facade.EmployeeFacade;

import java.util.Collection;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeFacade employeeFacade;

    @GetMapping
    public String findAll(Model model) {
        Collection<EmployeeDto> dtos = employeeFacade.findAll();
        model.addAttribute("employees", dtos);
        return "pages/employees/employees_all";
    }

    @GetMapping("/new")
    public String redirectToNewEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "pages/employees/employee_new";
    }

    @PostMapping("/new")
    public String newEmployee(@ModelAttribute EmployeeDto employee) {
        employeeFacade.create(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/update")
    public String redirectToUpdateEmployee(Model model, @PathVariable Long id) {
        model.addAttribute("employee", employeeFacade.findById(id));
        return "pages/employees/employee_update";
    }

    @PostMapping("/{id}/update")
    public String updateEmployee(@ModelAttribute EmployeeDto employee, @PathVariable Long id) {
        System.out.println("employee = " + employee);
        employeeFacade.update(id, employee);
        return "redirect:/employees";
    }
}
