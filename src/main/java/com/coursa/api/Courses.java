package com.coursa.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursa.domain.Course;
import com.coursa.services.CourseService;

@RestController()
@RequestMapping("/courses")
public class Courses implements CoursaAPI<Course> {

	@Autowired
	CourseService coursesService;
	
	@Override	
	public List<Course> getAll() {		
		return coursesService.getAllCourses();
	}

	@Override
	public Course add(@RequestBody Course course) {
		return coursesService.create(course);
	}

	@Override
	public Course update(@RequestBody Course course) {
		return null;
	}

	@Override
	public String delete(@PathVariable("id") Long id) {
		coursesService.delete(id);		
		return "Deleted";
	}
}
