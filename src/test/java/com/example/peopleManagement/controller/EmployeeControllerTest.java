package com.example.peopleManagement.controller;

import com.example.peopleManagement.entity.Employee;
import com.example.peopleManagement.service.EmployeeService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class EmployeeControllerTest {
    EmployeeService employeeService = mock(EmployeeService.class);
    EmployeeController employeeController = new EmployeeController(employeeService);

    @Test
    void showEmployees() {
        employeeController.showEmployees();
        verify(employeeService).showEmployees();
    }

    @Test
    void addEmployee() {
        employeeController.addEmployee();
        verify(employeeService).addEmployee();
    }

    @Test
    void saveEmployee() {
        Employee employee = new Employee(1, "Test", "test", "testing");
        employeeController.saveEmployee(employee);
        verify(employeeService).saveEmployee(employee);
    }

    @Test
    void showUpdateForm() {
        employeeController.showUpdateForm(1);
        verify(employeeService).showUpdateForm(1);
    }

    @Test
    void deleteEmployee() {
        employeeController.deleteEmployee(1);
        verify(employeeService).deleteEmployee(1);
    }
}