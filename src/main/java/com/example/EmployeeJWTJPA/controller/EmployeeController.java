package com.example.EmployeeJWTJPA.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.EmployeeJWTJPA.dto.EmployeeDTO;
import com.example.EmployeeJWTJPA.model.Employee;
import com.example.EmployeeJWTJPA.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee create(@Valid @RequestBody EmployeeDTO dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.getAll();
    }
}