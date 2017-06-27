package com.coursa.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coursa.domain.Student;
import com.coursa.domain.University;

@Transactional
public interface UniversityRepo extends JpaRepository<University, Long> {
	 
}
