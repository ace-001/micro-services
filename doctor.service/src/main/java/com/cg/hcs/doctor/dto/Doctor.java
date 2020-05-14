package com.cg.hcs.doctor.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="doctor")
@SequenceGenerator(name="docId",initialValue = 8989,allocationSize = 1)
public class Doctor 
{
	@Id
	@Column(name="doctor_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "docId")
	private Integer doctorId;
	@Column(name="doctor_name")
	private String doctorName;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private Users user;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="center_id")
	private DiagnosticCenter center;
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="test_id")
	private Test test;
	@Column(name="specialization")
	private String specialization;
	@Column(name="degree")
	private String degree;
	
	public Doctor() { }

	public Doctor(Integer doctorId, String doctorName, Users user, DiagnosticCenter center, Test test,
			String specialization, String degree) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.user = user;
		this.center = center;
		this.test = test;
		this.specialization = specialization;
		this.degree = degree;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	
}
