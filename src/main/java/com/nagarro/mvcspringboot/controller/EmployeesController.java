package com.nagarro.mvcspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.mvcspringboot.entities.EmployeeModel;
import com.nagarro.mvcspringboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee-api")
public class EmployeesController {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<EmployeeModel> getEmployees()
	{
		return employeeRepository.findAll();
	}
	
	@GetMapping(path="/employees/{id}")
	public ResponseEntity<? extends Object> getEmployeeById(@PathVariable(name="id") Long id)
	{
		Optional<EmployeeModel> employee = null;
		
		try {
			employee = employeeRepository.findById(id);
			
		} catch (Exception e) {
			return ResponseEntity.of(Optional.of(employee));
		}
		if(employee!=null)
		{
			return ResponseEntity.ok().body(employee);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/employees")
	public EmployeeModel createEmployee(@RequestBody EmployeeModel employee)
	{
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/employee/{id}")
	public EmployeeModel getEmployee(@PathVariable(name="id") Long id)
	{
//		EmployeeModel existingEmployee=employeeRepository.getById((long) 1);
		return employeeRepository.findById(id).get();
	}
	
	@PostMapping("/employees/{id}")
	public boolean updateEmployee(@PathVariable(name="id") Long id, @RequestBody EmployeeModel employeeDetails)
	{
		EmployeeModel existingEmployee=employeeRepository.findById(id).get();
		existingEmployee.setEmployeeName(employeeDetails.getEmployeeName());
		existingEmployee.setLocation(employeeDetails.getLocation());
		existingEmployee.setEmail(employeeDetails.getEmail());
		existingEmployee.setDob(employeeDetails.getDob());
		employeeRepository.save(existingEmployee);
		return true;
	}
	
	@DeleteMapping("/employees/{id}")
	public boolean deleteEmployee(@PathVariable(name="id") Long id)
	{
		employeeRepository.deleteById(id);
		return true;
	}
	
}
