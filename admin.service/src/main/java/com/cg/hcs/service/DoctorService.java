package com.cg.hcs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcs.dao.DoctorDAO;
import com.cg.hcs.dto.Doctor;

@Service
public class DoctorService 
{
	@Autowired
    DoctorDAO dodao;
    public void setDodao( DoctorDAO dodao) { this.dodao=dodao;}
    @Transactional
    public Doctor insertDoctor(Doctor doctor)
    {
        return dodao.save(doctor);
    }
    @Transactional
    public String deleteDoctor(int doctorId)
    {
    	dodao.deleteById(doctorId);
    	return "doctor Deleted";
    }
   
    @Transactional(readOnly=true)
    public Optional<Doctor> getDoctor(Integer doctorId)
    {
    	return dodao.findById(doctorId);
    }
    @Transactional(readOnly=true)
    public List<Doctor> getDoctors()
    {
    	return dodao.findAll();
    }
    @Transactional(readOnly=true)
    public Optional<Integer> getDoctorByCenterIdAndTestId(int centerId,int testId)
    {
    	return dodao.getDoctorByCenterIdTestId(testId, centerId);
    }
    @Transactional(readOnly=true)
    public Optional<Doctor> getDoctorUserId(String userId)
    {
    	return dodao.getDoctorByUser(userId);
    }
 }