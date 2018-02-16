package com.nsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nsc.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("Select U from User U where userName=:userName and password=:password")
	public User login(@Param("userName") String userName, @Param("password") String password);

	@Query("Select U from User U where userId=:userId")
	public User getUserById(@Param("userId")int userId);

	
	

}
