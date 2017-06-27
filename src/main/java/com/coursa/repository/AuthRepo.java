package com.coursa.repository;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.coursa.domain.CoursaUser;
import com.coursa.domain.Student;

@Transactional
public interface AuthRepo extends JpaRepository<CoursaUser, Long> {
	
	 @Query("SELECT c FROM CoursaUser c where c.userName = :email") 
	 CoursaUser findByEmail(@Param("email") String email);
	 
}
