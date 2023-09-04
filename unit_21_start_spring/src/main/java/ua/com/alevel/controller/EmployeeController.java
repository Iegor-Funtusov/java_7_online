package ua.com.alevel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
