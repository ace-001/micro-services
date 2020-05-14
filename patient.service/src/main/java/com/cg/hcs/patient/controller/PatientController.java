package com.cg.hcs.patient.controller;

import java.util.List;
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

import com.cg.hcs.patient.dto.Appointment;
import com.cg.hcs.patient.dto.DiagnosticCenter;
import com.cg.hcs.patient.dto.Patient;
import com.cg.hcs.patient.dto.Test;
import com.cg.hcs.patient.service.AppointmentService;
import com.cg.hcs.patient.service.DiagnosticcenterService;
import com.cg.hcs.patient.service.DoctorService;
import com.cg.hcs.patient.service.PatientService;
import com.cg.hcs.patient.service.TestCenterService;
import com.cg.hcs.patient.service.TestService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PatientController
{
	@Autowired
	AppointmentService appointmentService;
	public void setAppointmentService(AppointmentService appointmentService)
	{
		this.appointmentService=appointmentService;
	}
	@Autowired
	PatientService patientService;
	public void setPatientService(PatientService patientService)
	{
		this.patientService=patientService;
	}
	@Autowired
	DoctorService doctorService;
	public void setDoctorService(DoctorService doctorService)
	{
		this.doctorService=doctorService;
	}
	@Autowired
	DiagnosticcenterService diagnosticcenterService;
	public void setDiagnosticcenterService(DiagnosticcenterService diagnosticcenterService)
	{
		this.diagnosticcenterService=diagnosticcenterService;
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

	
	//Appointment Services
	
	@PostMapping(value="/addAppointment",consumes="application/json")
	public ResponseEntity<Boolean> insertAppointment(@RequestBody()Appointment appointment)
	{
		//String message="Appointment Successfully";
		Appointment dummy = appointmentService.getAppointmentByCenterIdAndAppointmentDate(appointment.getCenter().getCenterId(),appointment.getAppointmentDate());
		System.out.println(dummy!=null && dummy.getAppointmentDate().equals(appointment.getAppointmentDate()));
		if(dummy==null)
		{
			if(appointmentService.insertAppointment(appointment)==null)
				 return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);                    
		}
		else
			return new ResponseEntity<Boolean>(false,HttpStatus.NOT_ACCEPTABLE);
	}
	@GetMapping(value="/getAppointment/{appointmentId}",produces="application/json")
	public ResponseEntity<Optional<Appointment>> getAppointmentDetails(@PathVariable int appointmentId)
	{
		Optional<Appointment> appointment =  appointmentService.getAppointment(appointmentId);
		if(appointment.isPresent())
			return new ResponseEntity<Optional<Appointment>>(appointment,HttpStatus.OK);
		return new ResponseEntity<Optional<Appointment>>(appointment,HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/getAppointmentByDoc/{doctorId}",produces="application/json")
	public ResponseEntity<Optional<List<Appointment>>> getAppointmentByDoc(@PathVariable int doctorId)
	{
		Optional<List<Appointment>> appointment =  appointmentService.getAppointmentByDocId(doctorId);
		if(appointment.isPresent())
			return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.OK);
		return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/getAppointmentByPatient/{patientId}",produces="application/json")
	public ResponseEntity<Optional<List<Appointment>>> getAppointmentByPatient(@PathVariable int patientId)
	{
		Optional<List<Appointment>> appointment = appointmentService.getAppointmentByPatientId(patientId);
		if(appointment.isPresent())
			return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.OK);
		return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.NOT_FOUND);
	}
	
	//Patient Services	
	
	@GetMapping(value="/getPatient/{patientId}",produces="application/json")
	public ResponseEntity<Optional<Patient>> getPatientDetails(@PathVariable int patientId)
	{
		Optional<Patient> patient =  patientService.getPatient(patientId);
		if(patient.isPresent())
			return new ResponseEntity<Optional<Patient>>(patient,HttpStatus.OK);
		return new ResponseEntity<Optional<Patient>>(patient,HttpStatus.NOT_FOUND);
	}
	@GetMapping(value="/getPatientId/{userId}",produces="application/json")
	public ResponseEntity<Optional<Patient>> getPatientId(@PathVariable String userId)
	{
		Optional<Patient> patientDet = patientService.getPatient(userId);
		if(patientDet.isPresent())
			return new ResponseEntity<Optional<Patient>>(patientDet,HttpStatus.OK);
		return new ResponseEntity<Optional<Patient>>(patientDet,HttpStatus.NOT_FOUND);
	}
	
	//Doctor Services
	
	@GetMapping(value="/getDoctorByCenterAndTest/{centerId}/{testId}",produces="application/json")
	public ResponseEntity<Optional<Integer>> getDoctorId(@PathVariable int centerId,@PathVariable int testId)
	{
		Optional<Integer> doctorId =  doctorService.getDoctorByCenterIdAndTestId(centerId, testId);
		if(doctorId.isPresent())
			return new ResponseEntity<Optional<Integer>>(doctorId,HttpStatus.OK);
		return new ResponseEntity<Optional<Integer>>(doctorId,HttpStatus.NOT_FOUND);
	}
	
	//Center Services
	
	@GetMapping("/getDiagnosticcenters")
	public List<DiagnosticCenter> getDiagnosticcenters()
	{
		return diagnosticcenterService.getDiagnosticcenters();
	}
	
	//TestCenter Services
	
	@GetMapping(value="/getTestCenters/{centerId}",produces="application/json")
	public ResponseEntity<Optional<List<Integer>>> getTestCenterDetails(@PathVariable int centerId)
	{
		Optional<List<Integer>> testCenter =  testCenterService.getTestCenter(centerId);
		if(testCenter.isPresent())
			return new ResponseEntity<Optional<List<Integer>>>(testCenter,HttpStatus.OK);
		return new ResponseEntity<Optional<List<Integer>>>(testCenter,HttpStatus.NOT_FOUND);
	}
	
	
	//Test Services
	
	@GetMapping(value="/getTestsById/{testIds}",produces="application/json")
	public ResponseEntity<List<Test>> getMultipleTestById(@PathVariable int testIds[])
	{
		List<Test> test =  testService.getTestById(testIds);
		if(!test.isEmpty())
			return new ResponseEntity<List<Test>>(test,HttpStatus.OK);
		return new ResponseEntity<List<Test>>(test,HttpStatus.NOT_FOUND);
	}
}
