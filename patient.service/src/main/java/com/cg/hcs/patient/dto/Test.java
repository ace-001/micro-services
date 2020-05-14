package com.cg.hcs.patient.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="test")
@SequenceGenerator(name = "testIdGen",initialValue = 100,allocationSize = 1)
public class Test 
{
	@Id
	@Column(name = "test_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "testIdGen")
	private Integer testId;
	@Column(name = "test_name")
	private String testName;
	@Column(name = "description")
	private String description;
	@Column(name = "price")
	private int price;
	
	public Test() {	}

	public Test(Integer testId, String testName, String description, int price) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.description = description;
		this.price = price;
	}

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}