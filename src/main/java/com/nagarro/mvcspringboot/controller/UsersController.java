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
import com.nagarro.mvcspringboot.entities.UserLoginModel;
import com.nagarro.mvcspringboot.entities.UserModel;
import com.nagarro.mvcspringboot.repository.EmployeeRepository;
import com.nagarro.mvcspringboot.repository.UserRepository;

@RestController
@RequestMapping("/user-api")
public class UsersController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<UserModel> getUsers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/users-login")
	public boolean getUsersLogin(@RequestBody UserLoginModel userLoginModel) {
		Optional<UserModel> user = null;
		
		try {
			user = userRepository.findById(userLoginModel.getUserEmail());
			if (user.get().getPassword().equalsIgnoreCase(userLoginModel.getUserPassword())) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;
	}

//	@GetMapping(path = "/users/{email}")
//	public ResponseEntity<? extends Object> getUserById(@PathVariable(name = "email") String email) {
//		Optional<UserModel> user = null;
//
//		try {
//			user = userRepository.findById(email);
//
//		} catch (Exception e) {
//			return ResponseEntity.of(Optional.of(user));
//		}
//		if (user != null) {
//			return ResponseEntity.ok().body(user);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}

	@PostMapping("/users")
	public boolean createUser(@RequestBody UserModel user) {
		
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

//	@PutMapping("/users/{email}")
//	public UserModel updateUser(@PathVariable(name = "email") String email, @RequestBody UserModel userDetails) {
//		UserModel existingEmployee = userRepository.getById(email);
//		existingEmployee.setName(userDetails.getName());
//		existingEmployee.setEmail(userDetails.getEmail());
//		existingEmployee.setPassword(userDetails.getPassword());
//		return userRepository.save(existingEmployee);
//	}

//	@DeleteMapping("/users/{email}")
//	public boolean deleteUser(@PathVariable(name = "email") String email) {
//		userRepository.deleteById(email);
//		return true;
//	}

}
