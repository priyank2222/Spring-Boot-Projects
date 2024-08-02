package com.priyank.springDemo.service;

import java.util.List;

import com.priyank.springDemo.model.Employee;
 
public interface EmployeeServices {
	
    List<Employee> getAllEmployee();
    
    void save(Employee employee);
    
    Employee getById(Long id);
    
    void deleteViaId(long id);
}
