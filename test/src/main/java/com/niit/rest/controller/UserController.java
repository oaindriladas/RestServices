package com.niit.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillmapbackend.Employee;
import com.niit.services.DaoServices;


@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	DaoServices userService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> userList() {
		if (userService.get_all_employees().size() != 0) {
			return new ResponseEntity<List<Employee>>(userService.get_all_employees(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping
	public ResponseEntity<Void> insertuser(@RequestBody Employee emp)
	{
//		if(userService.get_emp_byID(emp.getEmployeeid()) != null )
//			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//		else
			userService.insert_record(emp);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

   @DeleteMapping
   public ResponseEntity<Void> deleteEmp(@RequestBody Employee emp)
   {
	   userService.del_emp(emp);
	   return new ResponseEntity<Void>(HttpStatus.OK);
   }
   }