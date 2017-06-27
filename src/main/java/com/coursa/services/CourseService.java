package com.coursa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursa.domain.CoursaUser;
import com.coursa.domain.Course;
import com.coursa.domain.Student;
import com.coursa.domain.University;
import com.coursa.domain.UserRole;
import com.coursa.repository.AuthRepo;
import com.coursa.repository.CourseRepo;
import com.coursa.repository.StudentRepo;
import com.coursa.repository.UserRolesRepo;

@Service
public class CourseService {
	
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	AuthRepo authRepo;

	@Autowired
	UserRolesRepo userRolesRepo;

	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		courseRepo.findAll().forEach(courses::add);
		return courses;
	}
	
	public Course update(Course course) {
		//studentRepo.update(student.getId(),student.getFirstName(),student.getLastName());
		return course;
	}
	
	public void delete(long id) {		
		//Course c = courseRepo.getOne(id);
		//userRolesRepo.deleteByUserId(c.getCoursaId());
		courseRepo.delete(id);		
		//authRepo.delete(s.getCoursaId());
		
	}

	public Course create(Course course) {
		
		// check course with the title if it exists
		Course c = courseRepo.findByTitle(course.getTitle());
		
		if (c == null) {
			
			//create new course
			c = courseRepo.saveAndFlush(course);
			
		} else {
			c = new Course();			
			System.out.println("course found : " + c);			
		}
		return c;
	}
}
