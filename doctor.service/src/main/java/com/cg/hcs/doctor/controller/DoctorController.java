package com.cg.hcs.doctor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcs.doctor.dto.Appointment;
import com.cg.hcs.doctor.dto.Doctor;
import com.cg.hcs.doctor.service.AppointmentService;
import com.cg.hcs.doctor.service.DoctorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DoctorController 
{
	@Autowired
	DoctorService doctorService;
	public void setDoctorService(DoctorService doctorService)
	{
		this.doctorService=doctorService;
	}
	@Autowired
	AppointmentService appointmentService;
	public void setAppointmentService(AppointmentService appointmentService)
	{
		this.appointmentService=appointmentService;
	}
	
	//Doctor Services
	
	@GetMapping(value="/getDoctorByUserId/{userId}",produces="application/json")
	public ResponseEntity<Optional<Doctor>> getDoctorIdByUserId(@PathVariable String userId)
	{
		Optional<Doctor> doctorId = doctorService.getDoctorUserId(userId);
		if(doctorId.isPresent())
			return new ResponseEntity<Optional<Doctor>>(doctorId,HttpStatus.OK);
		return new ResponseEntity<Optional<Doctor>>(doctorId,HttpStatus.NOT_FOUND);
	}
	
	//Appointment Services
	
	@GetMapping(value="/getAppointmentByDoc/{doctorId}",produces="application/json")
	public ResponseEntity<Optional<List<Appointment>>> getAppointmentByDoc(@PathVariable int doctorId)
	{
		Optional<List<Appointment>> appointment =  appointmentService.getAppointmentByDocId(doctorId);
		if(appointment.isPresent())
			return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.OK);
		return new ResponseEntity<Optional<List<Appointment>>>(appointment,HttpStatus.NOT_FOUND);
	}
}