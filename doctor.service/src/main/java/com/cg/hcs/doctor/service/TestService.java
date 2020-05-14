package com.cg.hcs.doctor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcs.doctor.dao.TestDAO;
import com.cg.hcs.doctor.dto.Test;

@Service
public class TestService 
{
	@Autowired
	TestDAO tdao;
	public void setTdao(TestDAO tdao)
	{
		this.tdao = tdao;
	}
	
	@Transactional
	public Test insertTest(Test test)
	{
		return tdao.save(test);
	}
	
	 @Transactional
	    public String deleteTest(int testId)
	    {
	    	tdao.deleteById(testId);
	    	return "test Deleted";
	    }
	 @Transactional(readOnly=true)
	    public List<Test> getTests()
	    {
	    	return tdao.findAll();
	    }
	 @Transactional(readOnly=true)
	    public Optional<Test> getTest(int testId)
	    {
	    	return tdao.findById(testId);
	    }
	 
	 @Transactional(readOnly=true)
	 public List<Test> getTestById(int testIds[])
	 {	 
		List<Test> results = new ArrayList<Test>();
 			for (int id : testIds) 
 			{
 				tdao.findById(id).ifPresent(results::add);
 			}
 		return results;
	} 
}
