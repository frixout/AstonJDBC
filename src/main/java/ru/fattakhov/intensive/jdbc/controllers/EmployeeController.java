package ru.fattakhov.intensive.jdbc.controllers;

import org.springframework.web.bind.annotation.*;
import ru.fattakhov.intensive.jdbc.DAO.EmployeeDAO;
import ru.fattakhov.intensive.jdbc.models.Employee;


@RestController
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostMapping("/employee")
    public Long createEmployee(@RequestBody Employee employee) {
        return employeeDAO.createEmployee(employee);
    }

    @GetMapping("/employee")
    public Employee getEmployeeById(@RequestParam Long id) {
        return employeeDAO.getEmployeeById(id);
    }

    @PutMapping("/employee")
    public void editEmployee(@RequestBody Employee employee){
        employeeDAO.updateEmployee(employee);
    }

    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam Long id){
        employeeDAO.deleteEmployee(id);
    }

}
