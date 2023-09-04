package ua.com.alevel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.alevel.facade.DepartmentFacade;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentFacade departmentFacade;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("departments", departmentFacade.findAll());
        return "pages/departments/departments_all";
    }

    @GetMapping("/employees/{id}")
    public String findAll(Model model, @PathVariable Long id) {
        model.addAttribute("departments", departmentFacade.findByEmployee(id));
        return "pages/departments/departments_all";
    }
}
