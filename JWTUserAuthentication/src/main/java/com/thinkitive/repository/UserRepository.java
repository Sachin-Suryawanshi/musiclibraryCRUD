package com.thinkitive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkitive.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByuserName(String name);

}
