package com.cg.hcs.patient.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@Column(name = "appointment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long appointmentId;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users user;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id")
	private DiagnosticCenter center;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
	private Test test;
	@Column(name="appointment_date")
    LocalDate appointmentDate;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
	private Doctor doctor;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
	private Patient patient;
	
	public Appointment() {}

	public Appointment(Long appointmentId, Users user, DiagnosticCenter center, Test test, LocalDate appointmentDate,
			Doctor doctor, Patient patient) {
		super();
		this.appointmentId = appointmentId;
		this.user = user;
		this.center = center;
		this.test = test;
		this.appointmentDate = appointmentDate;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public DiagnosticCenter getCenter() {
		return center;
	}

	public void setCenter(DiagnosticCenter center) {
		this.center = center;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	
}
