package com.cts.viewnews.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.viewnews.bean.Role;
import com.cts.viewnews.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);
	
	User findById(int id);
	
	List<User> findByRole(Role role);
	
	List<User> findByName(String name);

}
