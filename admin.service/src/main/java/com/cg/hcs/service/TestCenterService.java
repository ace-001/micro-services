package com.cg.hcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hcs.dao.TestCenterDAO;
import com.cg.hcs.dto.TestCenter;

@Service
public class TestCenterService 
{
	@Autowired
	TestCenterDAO tcdao;
    public void setTcdao( TestCenterDAO tcdao) { this.tcdao=tcdao;}
    
    @Transactional(readOnly=true)
    /*public TestCenter getTestCenter(int centerId)
    {
    	return tcdao.findByCenterId(centerId);
    }*/
    public Optional<List<Integer>> getTestCenter(int centerId)
    {
    	return tcdao.findByCenterId(centerId);
    }
    
    @Transactional
    public TestCenter addTestCenter(TestCenter testCenter)
    {
    	return tcdao.save(testCenter);
    }
    @Transactional(readOnly=true)
    public String deleteTestCenter(int tcId)
    {
    	String message ="";
    	TestCenter testCenter = tcdao.findById(tcId).get();
    	if(testCenter!=null)
    	{
    		tcdao.delete(testCenter);
    		message += "Test_center deleted";
     	}
    	else
    		message += "Cannot add Test_center";
    	return message;
    }
}