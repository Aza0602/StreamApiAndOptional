package com.github.aza0602.stream.streamapiandoptional.service;


import com.github.aza0602.stream.streamapiandoptional.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service

public class DepartmentService {
    private final EmployeeService employeeService;
    public Map<Integer, List<Employee>> getEmployeesByDepartment;

    public DepartmentService(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    public void changeDepartment(Employee employee, int department) {
        employeeService.getAll().stream()
                .filter(emp -> Objects.equals(employee, emp))
                .forEach(emp -> emp.setDepartment(department));
    }

    public Map<Integer, List<Employee>> findEmployeesByDepartment() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public void indexSalariesForDepartment(double index, int department) {
        employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .forEach(employee -> employee.setSalary((int) (employee.getSalary() * index / 100)));
    }

    public double avarageSalaryForDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .mapToInt(Employee::getSalary)
                .average()
                .orElse(0);
    }

    public Employee findEmployeeWithMinSalaryFromDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary)).orElse(null);
    }
    public Employee findEmployeeWithMaxSalaryFromDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary)).orElse(null);
    }
    public Employee totalSalariesForDepartment(int department) {
        return employeeService.getAll().stream()
                .mapToInt(Employee::getSalary).sum();
    }
    public List<Employee> findAllEmployeesFromDepartment(int department) {
        return employeeService.getAll().stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    public List<Employee> getAllEmployeesFromDepartment(int department) {
        return null;
    }
}
