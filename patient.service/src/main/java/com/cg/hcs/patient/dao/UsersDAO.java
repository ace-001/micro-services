package com.cg.hcs.patient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.patient.dto.Users;


public interface UsersDAO extends JpaRepository<Users, String>
{

}
