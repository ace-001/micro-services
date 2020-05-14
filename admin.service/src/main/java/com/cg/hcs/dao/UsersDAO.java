package com.cg.hcs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.dto.Users;

public interface UsersDAO extends JpaRepository<Users, String>
{

}