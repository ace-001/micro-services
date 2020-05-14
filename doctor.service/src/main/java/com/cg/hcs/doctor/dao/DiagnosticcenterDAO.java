package com.cg.hcs.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcs.doctor.dto.DiagnosticCenter;


@Repository
public interface DiagnosticcenterDAO extends JpaRepository<DiagnosticCenter, Integer> 
{

}
