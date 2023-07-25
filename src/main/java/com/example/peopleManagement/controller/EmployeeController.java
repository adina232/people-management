package com.example.peopleManagement.controller;

import com.example.peopleManagement.entity.Employee;
import com.example.peopleManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ModelAndView showEmployees() {
        return employeeService.showEmployees();
    }

    @GetMapping("/addEmployee")
    public ModelAndView addEmployee() {
        return employeeService.addEmployee();
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Integer id) {
        return employeeService.showUpdateForm(id);
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Integer id) {
        return employeeService.deleteEmployee(id);
    }

}
