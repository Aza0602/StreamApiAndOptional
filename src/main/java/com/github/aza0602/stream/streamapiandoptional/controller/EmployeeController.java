package com.github.aza0602.stream.streamapiandoptional.controller;


import com.github.aza0602.stream.streamapiandoptional.model.Employee;
import com.github.aza0602.stream.streamapiandoptional.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam ("firstName") String firstName,
                        @RequestParam ("lastName") String lastName,
                        @RequestParam ("department") int department,
                        @RequestParam ("salary") int salary) {
        return EmployeeService.add(firstName, lastName, department, salary);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName) {
        return EmployeeService.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName) {
        return EmployeeService.find(firstName, lastName);
    }

        @GetMapping("/")
        public Collection<Employee> employees() {
            return employeeService.employees();
        }
}
