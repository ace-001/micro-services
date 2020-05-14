package com.cg.hcs.doctor.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcs.doctor.dao.AppointmentDAO;
import com.cg.hcs.doctor.dto.Appointment;

@Service
public class AppointmentService {
	@Autowired
    AppointmentDAO adao;
    public void setAdao(   AppointmentDAO adao) 
    { 
    	this.adao=adao;
    	} 
    @Transactional
    public Appointment insertAppointment(Appointment appointment)
    {
        return adao.save(appointment);
    }
    @Transactional(readOnly = true)
    public Appointment getAppointmentByCenterIdAndAppointmentDate(int centerId,LocalDate appointmentDate)
    {
    	return adao.getAppointmentByCenterIdAndAppointmentDate(centerId,appointmentDate);
    }
    @Transactional(readOnly=true)
    public Optional<Appointment> getAppointment(Integer appointmentId)
    {
    	return adao.findById(appointmentId);
    }
	public Optional<List<Appointment>> getAppointmentByDocId(int doctorId) 
	{
		return adao.getAppointmentsByDocId(doctorId);
	}
	public Optional<List<Appointment>> getAppointmentByPatientId(int patientId) 
	{
		return adao.getAppointmentsByPatientId(patientId);
	}
    
	/*
	 * @Transactional(readOnly=true) public Optional<List<Appointment>>
	 * getAppointmentByDoctorId(Doctor doctor) { return
	 * adao.getAppointmentsByDoctorId(doctor); }
	 */
 }