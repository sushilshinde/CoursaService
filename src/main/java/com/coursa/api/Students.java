package com.coursa.api;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coursa.domain.CoursaUser;
import com.coursa.domain.Course;
import com.coursa.domain.Student;
import com.coursa.domain.UserRole;
import com.coursa.repository.AuthRepo;
import com.coursa.repository.StudentRepo;
import com.coursa.repository.UserRolesRepo;
import com.coursa.services.StudentService;


@RestController()
@RequestMapping("/students")
public class Students implements CoursaAPI<Student> {
	
	@Autowired
	StudentService studentService;
	
	
	@Override	
	public List<Student> getAll() {
		return studentService.getAllStudents();
	}

	@Override
	public Student add(@RequestBody Student student) {	
		return studentService.create(student);		
	}

	@Override
	public Student update(@RequestBody Student student) {
		return studentService.update(student);
	}

	@Override
	public String delete(@PathVariable("id") Long id) {
		studentService.delete(id);
		return "Deleted";
	}
	
	private void print(Object obj){
		System.out.println(obj);
	}
	
}