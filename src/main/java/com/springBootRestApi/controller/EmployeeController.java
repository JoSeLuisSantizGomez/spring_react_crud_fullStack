package com.springBootRestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootRestApi.repository.EmployeeRepository;
import com.springBootRestApi.entity.Employee;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {
	
	private EmployeeRepository eRepo;

	public EmployeeController(EmployeeRepository eRepo) {
		this.eRepo = eRepo;
	}
	
	//Lista de empleados
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return eRepo.findAll();
	}
	
	//Agregar nuevo empleado
	@PostMapping("/employees")
	public Employee saveEmployeeDetails(@RequestBody Employee employee) {
		return eRepo.save(employee);
	}
	
	//Buscar un empleado por ID
	@GetMapping("/employees/{id}")
	public Employee getSingleEmployee(@PathVariable Long id) {
		return eRepo.findById(id).get();
	}
	
	//Actualizar un empleado
	@PutMapping("/employees")
	public Employee updateEmployeeDetails(@RequestBody Employee employee) {
		return eRepo.save(employee);
	}

	
	//Eliminar a un empleado
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id){
		eRepo.deleteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
