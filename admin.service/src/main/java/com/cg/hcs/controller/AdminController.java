package com.cg.hcs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.hcs.dto.DiagnosticCenter;
import com.cg.hcs.dto.Doctor;
import com.cg.hcs.dto.Test;
import com.cg.hcs.dto.TestCenter;
import com.cg.hcs.service.DiagnosticcenterService;
import com.cg.hcs.service.DoctorService;
import com.cg.hcs.service.TestCenterService;
import com.cg.hcs.service.TestService;

public class AdminController 
{
	@Autowired
	DiagnosticcenterService diagnosticcenterService;
	public void setDiagnosticcenterService(DiagnosticcenterService diagnosticcenterService)
	{
		this.diagnosticcenterService=diagnosticcenterService;
	}
	@Autowired
	DoctorService doctorService;
	public void setDoctorService(DoctorService doctorService)
	{
		this.doctorService=doctorService;
	}
	@Autowired
	TestCenterService testCenterService;
	public void setTestCenterService(TestCenterService testCenterService)
	{
		this.testCenterService = testCenterService;
	}
	@Autowired
	TestService testService;
	public void setTestService(TestService testService)
	{
		this.testService = testService;
	}
	
	//Center Services
	
	@PostMapping(value="/addDiagnosticcenter",consumes="application/json")
	public ResponseEntity<String> insertDiagnosticcenter(@RequestBody()DiagnosticCenter diagnosticcenter)
	{
		try
		{
			String message="center Inserted Successfully";
			if(diagnosticcenterService.insertDiagnosticcenter(diagnosticcenter)==null)
				message="Center Insertion Failed";
			return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
		}  
	}
	@DeleteMapping("/deleteDiagnosticcenter/{centerId}")
	public String deleteDiagnosticcenter(@PathVariable int centerId)
	{
		return diagnosticcenterService.deleteDiagnosticcenter(centerId); 
	}
	@GetMapping("/getDiagnosticcenters")
	public List<DiagnosticCenter> getDiagnosticcenters()
	{
		return diagnosticcenterService.getDiagnosticcenters();
	}   
	@GetMapping(value="/getDiagnosticcenter/{centerId}",produces="application/json")
	public ResponseEntity<Optional<DiagnosticCenter>> getDiagnosticcenterDetails(@PathVariable int centerId)
	{
		Optional<DiagnosticCenter> diagnosticcenter =  diagnosticcenterService.getDiagnosticcenter(centerId);
		if(diagnosticcenter.isPresent())
			return new ResponseEntity<Optional<DiagnosticCenter>>(diagnosticcenter,HttpStatus.OK);
		return new ResponseEntity<Optional<DiagnosticCenter>>(diagnosticcenter,HttpStatus.NOT_FOUND);
	}   
	
	//Doctor Services
	
	@PostMapping(value="/addDoctor",consumes="application/json")
	public ResponseEntity<String> insertDoctor(@RequestBody()Doctor doctor)
	{
		try
		{
			String message="Doctor Inserted Successfully";
			if(doctorService.insertDoctor(doctor)==null)
				message="Doctor Insertion Failed";
			return new ResponseEntity<String>(message,HttpStatus.CREATED);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deleteDoctor/{doctorId}")
	public String deleteDoctor(@PathVariable int doctorId)
	{
		return doctorService.deleteDoctor(doctorId);
	}
	@GetMapping(value="/getDoctors",produces="application/json")
	public List<Doctor> getDoctors()
	{
		return doctorService.getDoctors();
	}
	@GetMapping(value="/getDoctor/{doctorId}",produces="application/json")
	public ResponseEntity<Optional<Doctor>> getDoctorDetails(@PathVariable int doctorId)
	{
		Optional<Doctor> doctor =  doctorService.getDoctor(doctorId);
		if(doctor.isPresent())
			return new ResponseEntity<Optional<Doctor>>(doctor,HttpStatus.OK);
		return new ResponseEntity<Optional<Doctor>>(doctor,HttpStatus.NOT_FOUND);
	}
	
	//TestCenter Services
	
	@DeleteMapping("/deleteTestCenter/{tcId}")
	public String deleteTestCenter(@PathVariable int tcId)
	{
		return testCenterService.deleteTestCenter(tcId); 
	}	
	@PostMapping(value="/addTestCenter",consumes="application/json")
	public ResponseEntity<String> insertTestCenter(@RequestBody()TestCenter testCenter)
	{
		String message;
		try
		{
			message="Test Inserted Successfully";
			if(testCenterService.addTestCenter(testCenter)==null)
				message="Test Insertion Failed";
			return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);	
		}
	}	
	
	//Test Services
	
	@PostMapping(value="/addTest",consumes="application/json")
	public ResponseEntity<String> insertTest(@RequestBody()Test test)
	{
		try
		{
			String message="Test Inserted Successfully";
			if(testService.insertTest(test)==null)
				message="Test Insertion Failed";
			return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
		}
		catch(Exception ex)
		{
			return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);	
		}
	}
	@GetMapping("/getTests")	
	public List<Test> getTests()
	{
		return testService.getTests();
	}
	@GetMapping(value="/getTest/{testId}",produces="application/json")
	public ResponseEntity<Optional<Test>> getTestDetails(@PathVariable int testId)
	{
		Optional<Test> test =  testService.getTest(testId);
		if(test.isPresent())
			return new ResponseEntity<Optional<Test>>(test,HttpStatus.OK);
		return new ResponseEntity<Optional<Test>>(test,HttpStatus.NOT_FOUND);
	}
}