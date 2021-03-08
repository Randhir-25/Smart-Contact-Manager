package com.smart.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByName(String name);
	
	
	  @Query("select u from User u where u.email =:e") 
	  public List<User> getUserByEmail(@Param("e") String email);
	  
	  @Query("select u from User u where u.name =:n and u.role =:r")
	  public List<User> getUserByNameAndRole(@Param("n") String name, @Param("r") String role);
	 
	  @Query("select u from User u")
	  public List<User> getAllUser();
	  
	  @Query(value="select * from User", nativeQuery = true)
	  public List<User> getUsers();
	

}
