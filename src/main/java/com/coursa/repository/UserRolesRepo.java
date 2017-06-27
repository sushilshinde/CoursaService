package com.coursa.repository;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.coursa.domain.CoursaUser;
import com.coursa.domain.Student;
import com.coursa.domain.UserRole;

@Transactional
public interface UserRolesRepo extends JpaRepository<UserRole, Long> {
	
	@Modifying
	@Query("DELETE FROM UserRole ur where ur.userId = :id") 
	 void deleteByUserId(@Param("id") long id);	 
}
