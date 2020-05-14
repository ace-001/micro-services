package com.cg.hcs.doctor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.doctor.dto.Users;

public interface UsersDAO extends JpaRepository<Users, String>
{

}
