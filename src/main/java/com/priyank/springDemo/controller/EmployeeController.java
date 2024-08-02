package com.priyank.springDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
import com.priyank.springDemo.model.Employee;
import com.priyank.springDemo.service.EmployeeServicesImplementation;
 
@Controller
public class EmployeeController {
 
    @Autowired
    private EmployeeServicesImplementation employeeServicesImplementation;
 
    @GetMapping("/")
    public String viewHomePage(Model model) {
    	
        model.addAttribute("allemplist", employeeServicesImplementation.getAllEmployee());
        return "index";
    }
 
    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
    	
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "newemployee";
    }
 
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    	
    	employeeServicesImplementation.save(employee);
        return "redirect:/";
    }
 
    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
    	
        Employee employee = employeeServicesImplementation.getById(id);
        model.addAttribute("employee", employee);
        return "update";
    } 
 
    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
    	
    	employeeServicesImplementation.deleteViaId(id);
        return "redirect:/";
 
    }
}
