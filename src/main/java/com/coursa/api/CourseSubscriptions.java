package com.coursa.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursa.domain.Course;
import com.coursa.domain.CourseSubscription;
import com.coursa.domain.Student;

@RestController()
@RequestMapping("/coursesubscriptions")
public class CourseSubscriptions implements CoursaAPI<CourseSubscription> {

	@Override	
	public List<CourseSubscription> getAll() {		
		return null;
	}

	@Override
	public CourseSubscription add(@RequestBody CourseSubscription courseSubscription) {
		return null;
	}

	@Override
	public CourseSubscription update(@RequestBody CourseSubscription courseSubscription) {
		return null;
	}

	@Override
	public String delete(Long id) {
		return "CourseSubscription Deleted";
	}
}