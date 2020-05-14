package com.cg.hcs.patient.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcs.patient.dto.Appointment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface AppointmentDAO extends JpaRepository<Appointment,Integer> 
{
	@Query("select a from Appointment a where a.center.centerId=:centerId and a.appointmentDate=:appointmentDate")
	public Appointment getAppointmentByCenterIdAndAppointmentDate(@Param("centerId") int centerId,@Param("appointmentDate") LocalDate appointmentDate);
	@Query("select a from Appointment a where a.doctor.doctorId=:doctorId")
	public Optional<List<Appointment>> getAppointmentsByDocId(@Param("doctorId")int doctorId);
	@Query("select a from Appointment a where a.patient.patientId=:patientId")
	public Optional<List<Appointment>> getAppointmentsByPatientId(@Param("patientId")int patientId);
}