package com.cg.hcs.user.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.user.dto.Patient;
import com.cg.hcs.user.dto.Users;
import com.cg.hcs.user.service.PatientService;
import com.cg.hcs.user.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UsersController 
{
	@Autowired
	UserService userService;
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}	
	@Autowired
	PatientService patientService;
	public void setPatientService(PatientService patientService)
	{
		this.patientService=patientService;
	}
	
	//Users services
	
	@GetMapping("/login/{user_id}/{password}")
	public ResponseEntity<Optional<Users>> checkUser(@PathVariable String user_id,@PathVariable String password)
	{
		System.out.println(" "+user_id+" "+password);
		Optional<Users> user = userService.getUserById(user_id);
		try
		{
			if(user!=null && user.get().getPassword().equals(password))
				return new ResponseEntity<Optional<Users>>(user,HttpStatus.OK);
		}
		catch(NoSuchElementException e)
		{
			return new ResponseEntity<Optional<Users>>(user,HttpStatus.NOT_FOUND);
		}
		return null;
	}

	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<String> registerUser(@RequestBody Users user)
	{
		try 
		{
			String message="Registered Successfully";
			if(userService.getUserById(user.getUserId()).isPresent())
			{
				message="Registration Failed";
				return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
			}
			else
				if(userService.addUser(user)==null || user.getPassword().isEmpty())
				{
					message="Registration Failed";
					return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
				}
			else
				return new ResponseEntity<String>(message,HttpStatus.CREATED);	
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>("Registration Failed",HttpStatus.BAD_REQUEST);
		}
	}
	
	//Patient Services
	
	@PostMapping(value="/addPatient",consumes="application/json")
	public ResponseEntity<String> insertPatient(@RequestBody()Patient patient)
	{
		try
		{
			String message="Patient Inserted Successfully";
			if(patientService.insertPatient(patient).getPatientId()==null)
				message="Patient Insertion Failed";
			return new ResponseEntity<String>(message,HttpStatus.CREATED);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
		}
	}

	
}