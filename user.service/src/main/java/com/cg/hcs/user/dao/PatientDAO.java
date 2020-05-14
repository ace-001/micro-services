package com.cg.hcs.user.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.hcs.user.dto.Patient;

public interface PatientDAO extends JpaRepository<Patient, Integer>
{
	@Query("select p from Patient p where p.user.userId=:userId")
	public Optional<Patient> getPatientByUserId(@Param("userId")String userId); 
}
