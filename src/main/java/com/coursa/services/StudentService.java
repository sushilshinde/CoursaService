package com.coursa.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coursa.domain.CoursaUser;
import com.coursa.domain.Student;
import com.coursa.domain.University;
import com.coursa.domain.UserRole;
import com.coursa.repository.AuthRepo;
import com.coursa.repository.StudentRepo;
import com.coursa.repository.UserRolesRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	AuthRepo authRepo;

	@Autowired
	UserRolesRepo userRolesRepo;

	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		studentRepo.findAll().forEach(students::add);
		return students;
	}
	
	public Student update(Student student) {
		//studentRepo.update(student.getId(),student.getFirstName(),student.getLastName());
		return student;
	}
	
	public void delete(long id) {
		
		Student s = studentRepo.getOne(id);
		userRolesRepo.deleteByUserId(s.getCoursaId());
		studentRepo.delete(id);		
		authRepo.delete(s.getCoursaId());
		
	}

	public Student create(Student student) {
		
		Student s = new Student();
		
		// check students exist or not
		CoursaUser cu = authRepo.findByEmail(student.getUserNameEmail());
		
		if (cu == null) {
			
			//create access
			cu = new CoursaUser();
			cu.setUserName(student.getUserNameEmail());
			cu.setPassword(student.getPassword());
			cu = authRepo.saveAndFlush(cu);
		
			System.out.println("CoursaUser : " + cu);
			
			if (cu.getId() != 0) {
				
				//create role
				UserRole userRole = new UserRole();
				userRole.setRoleId(3);
				userRole.setUserId(cu.getId());
				userRole = userRolesRepo.saveAndFlush(userRole);

				// create student
				student.setCoursaId(cu.getId());
				s = studentRepo.saveAndFlush(student);
			}

		} else {
			System.out.println("Student found : " + s);
		}
		return s;
	}
}
