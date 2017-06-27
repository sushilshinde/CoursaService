package com.coursa.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coursa.domain.Student;

@Transactional
public interface StudentRepo extends JpaRepository<Student, Long> {
	
	 	//
	   /* @Modifying(clearAutomatically = true)
	    @Query("UPDATE Student s SET s.firstName = :firstName and s.lastName = :lastName  WHERE s.id = :id")
	    int update(@Param("id") long id, @Param("firstName") String firstName, @Param("lastName") String lastName);*/
	 
}
