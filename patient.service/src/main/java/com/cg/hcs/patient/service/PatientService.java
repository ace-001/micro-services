package com.cg.hcs.patient.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcs.patient.dao.PatientDAO;
import com.cg.hcs.patient.dto.Patient;

@Service
public class PatientService 
{
	@Autowired
	PatientDAO pdao;
    public void setPdao( PatientDAO pdao) { this.pdao=pdao;}
    @Transactional
    public Patient insertPatient(Patient patient)
    {
        return pdao.save(patient);
    }
    @Transactional
    public String deletePatient(int patientId)
    {
    	pdao.deleteById(patientId);
    	return "patient Deleted";
    }
   
    @Transactional(readOnly=true)
    public Optional<Patient> getPatient(Integer patientId)
    {
    	return pdao.findById(patientId);
    }
    @Transactional(readOnly=true)
    public List<Patient> getPatients()
    {
    	return pdao.findAll();
    }
    @Transactional(readOnly=true)
    public Optional<Patient> getPatient(String userId)
    {
    	return pdao.getPatientByUserId(userId);
    }    
}
