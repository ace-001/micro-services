package com.cg.hcs.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcs.doctor.dto.Test;

@Repository
public interface TestDAO extends JpaRepository<Test, Integer>
{

}
