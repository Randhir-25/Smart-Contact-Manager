package com.smart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.smart.dao.UserRepository;
import com.smart.entities.User;

@SpringBootApplication
public class SmartContactManagerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SmartContactManagerApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);
		// Find one User Details
		// Optional<User> optional=userRepository.findById(1);
		// System.out.println(optional);
		// Find All User Details
		List<User> users = userRepository.findAll();
		/*
		 * for (User user : users) { System.out.println(user); }
		 */
		users.forEach(user -> {
			System.out.println(user);
		});
		// Save One Value
		
		 /* User user = new User(); user.setName("Randhir");
		  user.setEmail("randhir@gmail.com"); user.setPassword("12345");
		  user.setRole("Admin"); 
		  //userRepository.save(user); 
		  User user1 = new User(); 
		  user1.setName("Rishabh"); user1.setEmail("rishabh@gmail.com");
		  user1.setPassword("98765"); user1.setRole("Employee"); List<User>
		  result=List.of(user, user1);
		  
			/*
			 * List<User> userList =new ArrayList(); userList.add(user);
			 * userList.add(user1); List<User> result=userRepository.saveAll(userList);
			 */
		  
		 // userRepository.saveAll(result);
		 
		//Update the Value by Id
		/*
		 * Optional<User> optional1=userRepository.findById(5); User
		 * user2=optional1.get(); user2.setPassword("99999");
		 * userRepository.save(user2); 
		 * //Delete User by Id 
		 * userRepository.deleteById(8);
		 */
		
		/*
		 * Iterable<User> allusers = userRepository.findAll(); allusers.forEach(user ->
		 * System.out.println(user)); userRepository.deleteAll(allusers);
		 */
		System.out.println("-------------------------------------");
		List<User> userByName=userRepository.findByName("Randhir");
		System.out.println(userByName);
		System.out.println("--------------------------------------");
		List<User> allUser=userRepository.getAllUser();
		allUser.forEach(user -> System.out.println(user));
		System.out.println("----------------------------------------------");
		List<User> oneUser=userRepository.getUserByEmail("rishabh@gmail.com");
		oneUser.forEach(user->{
			System.out.println(user);
		});
		System.out.println("===============================================");
		List<User> userByNameAndRole=userRepository.getUserByNameAndRole("Randhir", "Admin");
		userByNameAndRole.forEach(user->{
			System.out.println(user);
		});
		
		System.out.println("============================================");
		List<User> usingNativeQuery=userRepository.getUsers();
		usingNativeQuery.forEach(user ->System.out.println(user));
	}

}
