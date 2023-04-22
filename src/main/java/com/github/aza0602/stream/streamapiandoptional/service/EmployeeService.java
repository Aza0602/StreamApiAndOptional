package com.github.aza0602.stream.streamapiandoptional.service;

import com.github.aza0602.stream.streamapiandoptional.exception.EmployeeAlreadyAddedException;
import com.github.aza0602.stream.streamapiandoptional.exception.EmployeeNotFoundException;
import com.github.aza0602.stream.streamapiandoptional.exception.EmployeeStoragesFullException;
import com.github.aza0602.stream.streamapiandoptional.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private static final Map<String, Employee> employees = new HashMap<>();

    private static String getKey(String firstName, String lastName) {
        return firstName + " | " + lastName;
    }


    public static Employee add(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStoragesFullException();
    }



    public static Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public static Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }

    public Collection<Employee> employees() {
        return null;
    }
}
