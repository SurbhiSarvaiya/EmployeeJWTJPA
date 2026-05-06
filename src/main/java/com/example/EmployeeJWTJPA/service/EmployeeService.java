package com.example.EmployeeJWTJPA.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.EmployeeJWTJPA.dto.EmployeeDTO;
import com.example.EmployeeJWTJPA.model.Employee;
import com.example.EmployeeJWTJPA.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public Employee save(EmployeeDTO dto) {
        Employee e = new Employee();
        e.setName(dto.getName());
        e.setDepartment(dto.getDepartment());
        e.setSalary(dto.getSalary());
        return repo.save(e);
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }
}