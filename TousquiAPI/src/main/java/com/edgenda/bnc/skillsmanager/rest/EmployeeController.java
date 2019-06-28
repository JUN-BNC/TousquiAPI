package com.edgenda.bnc.skillsmanager.rest;

import com.edgenda.bnc.skillsmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired private EmployeeService employeeService;

    @RequestMapping(path = "" , method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(path = "/{id}/skills" , method = RequestMethod.GET)
    public List<Skill> getEmployeesSkills(@PathVariable Long id) {
        return employeeService.getEmployee(id).getSkills();
    }

    @RequestMapping(path = "/{id}" , method = RequestMethod.GET)
    public Employee getEmployees(@PathVariable Long id) {
    return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmploye(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return employeeService.getEmployee(employee.getId());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

}
