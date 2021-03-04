package ru.jobint.spring.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.jobint.spring.entities.Student;
import ru.jobint.spring.services.StudentService;

import java.util.Optional;


@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService service;

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students", service.findAll());
        return "students";
    }

    @GetMapping("/{id}")
    public String getStudentById(Model model, @PathVariable Long id) {
        Optional<Student> student = service.findById(id);
        if (student.isEmpty()) {
            throw new RuntimeException("Resource not found");
        }
        model.addAttribute("student", student.get());
        return "student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/students";
    }

    @GetMapping("/new")
    public String showCreateStudentForm() {
        return "new_student";
    }

    @PostMapping("/new")
    public String createStudent(@RequestParam(value = "name") String name,
                                @RequestParam(value = "age") int age) {
        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setAge(age);
        service.save(newStudent);
        return "redirect:/students";
    }

    @PostMapping
    public String updateStudent(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students";
    }
}
