package com.cg.hcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcs.dto.DiagnosticCenter;

@Repository
public interface DiagnosticcenterDAO extends JpaRepository<DiagnosticCenter, Integer> 
{

}