package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "student_all";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.findById(id));
        return "student_details";
    }

    @GetMapping("new")
    public String redirectToNewStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student_new";
    }

    @PostMapping("new")
    public String create(@ModelAttribute Student student) {
        studentService.create(student);
        return "redirect:/students";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
