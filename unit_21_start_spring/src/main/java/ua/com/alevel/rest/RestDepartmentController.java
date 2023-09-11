package ua.com.alevel.rest;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.DepartmentDto;

import ua.com.alevel.facade.DepartmentFacade;

import java.util.Collection;

@Controller
@RequestMapping("/api/departments")
public class RestDepartmentController {

    @Autowired
    private DepartmentFacade departmentFacade;

    @GetMapping
    public @ResponseBody Collection<DepartmentDto> findAll() {
        return departmentFacade.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody DepartmentDto findById(@PathVariable Long id) {
        return departmentFacade.findById(id);
    }

    @PostMapping
    public @ResponseBody Boolean create(@RequestBody DepartmentDto dto, HttpServletResponse response) {
        response.setStatus(201);
        departmentFacade.create(dto);
        return true;
    }
}
