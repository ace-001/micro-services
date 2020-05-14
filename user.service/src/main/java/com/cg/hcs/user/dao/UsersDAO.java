package com.cg.hcs.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcs.user.dto.Users;

public interface UsersDAO extends JpaRepository<Users, String>
{

}
