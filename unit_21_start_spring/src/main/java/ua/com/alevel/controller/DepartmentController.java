package ua.com.alevel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import ua.com.alevel.facade.DepartmentFacade;
import ua.com.alevel.facade.EmployeeFacade;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentFacade departmentFacade;

    @Autowired
    private EmployeeFacade employeeFacade;

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

    @GetMapping("/{id}/employees/attach")
    public String getAttachPage(Model model, @PathVariable Long id) {
        model.addAttribute("employeesByDepartment", employeeFacade.findAllEmployeesByDepartment(id));
        model.addAttribute("employeesByExcludeDepartment", employeeFacade.findAllEmployeesByExcludeDepartment(id));
        model.addAttribute("departmentId", id);
        return "pages/departments/departments_attach";
    }

    @PostMapping("/employees/attach")
    public String attachOrDetach(WebRequest request) {
        long depId = Long.parseLong(request.getParameter("depId"));
        long empId = Long.parseLong(request.getParameter("empId"));
        boolean attachOrDetach = Boolean.parseBoolean(request.getParameter("attachOrDetach"));

        //todo implements attach/detach employee to department

        return "redirect:/departments/" + depId + "/employees/attach";
    }
}
