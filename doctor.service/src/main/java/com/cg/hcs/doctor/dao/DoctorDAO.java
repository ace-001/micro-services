package com.cg.hcs.doctor.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.hcs.doctor.dto.Doctor;

public interface DoctorDAO extends JpaRepository<Doctor, Integer>
{
	@Query("select d from Doctor d where d.user.userId=:userId")
	public Optional<Doctor> getDoctorByUser(@Param("userId")String userId); 
	@Query("select d.doctorId from Doctor d where d.test.testId=:testId and d.center.centerId=:centerId")
	public Optional<Integer> getDoctorByCenterIdTestId(@Param("testId")int testId,@Param("centerId")int centerId);
}