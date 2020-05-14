package com.cg.hcs.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.hcs.dto.TestCenter;

public interface TestCenterDAO extends JpaRepository<TestCenter, Integer>
{
	@Query("select t.testId from TestCenter t where t.centerId=:centerId")
	public Optional<List<Integer>> findByCenterId(@Param("centerId")Integer centerId);	
}