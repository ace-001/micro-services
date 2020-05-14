package com.cg.hcs.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hcs.dto.Test;

@Repository
public interface TestDAO extends JpaRepository<Test, Integer>
{
	
}