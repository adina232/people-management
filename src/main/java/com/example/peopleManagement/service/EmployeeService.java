package com.example.peopleManagement.service;

import com.example.peopleManagement.entity.Employee;
import com.example.peopleManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public ModelAndView showEmployees() {
        ModelAndView mav = new ModelAndView("home");
        List<Employee> list = employeeRepository.findAll();

        mav.addObject("employees", list);

        return mav;
    }

    public ModelAndView addEmployee() {
        ModelAndView mav = new ModelAndView("addEmployee");
        Employee employee = new Employee();
        mav.addObject("employee", employee);
        return mav;
    }

    public String saveEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/";
    }

    public ModelAndView showUpdateForm(Integer id) {
        ModelAndView mav = new ModelAndView("addEmployee");
        Employee employee = employeeRepository.findById(id).get();
        mav.addObject("employee", employee);
        return mav;
    }

    public String deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return "redirect:/";
    }

}
