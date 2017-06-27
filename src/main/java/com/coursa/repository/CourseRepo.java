package com.coursa.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coursa.domain.CoursaUser;
import com.coursa.domain.Course;
import com.coursa.domain.Student;
import com.coursa.domain.University;

@Transactional
public interface CourseRepo extends JpaRepository<Course, Long> {

	@Query("SELECT c FROM Course c where c.title = :title") 
	 Course findByTitle(@Param("title") String title);
}
