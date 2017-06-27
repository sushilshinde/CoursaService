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
import com.coursa.repository.UniversityRepo;
import com.coursa.repository.UserRolesRepo;

@Service
public class UniversityService {

	@Autowired
	UniversityRepo universityRepo;

	@Autowired
	AuthRepo authRepo;

	@Autowired
	UserRolesRepo userRolesRepo;

	public List<University> getAllUniversties() {

		System.out.println("getAllUniversties...");

		List<University> universities = new ArrayList<University>();
		universityRepo.findAll().forEach(universities::add);
		return universities;
	}

	public void delete(long id) {
		
		University u = universityRepo.getOne(id);
		userRolesRepo.deleteByUserId(u.getCoursaId());
		universityRepo.delete(id);
		authRepo.delete(u.getCoursaId());
	}

	public University create(University university) {

		System.out.println("create...");

		University u = new University();

		// check university exist or not
		CoursaUser cu = authRepo.findByEmail(university.getUserNameEmail());

		if (cu == null) {

			// create access
			cu = new CoursaUser();
			cu.setUserName(university.getUserNameEmail());
			cu.setPassword(university.getPassword());
			cu = authRepo.saveAndFlush(cu);

			System.out.println("CoursaUser : " + cu);

			if (cu.getId() != 0) {

				// create role
				UserRole userRole = new UserRole();
				userRole.setRoleId(2);
				userRole.setUserId(cu.getId());
				userRole = userRolesRepo.saveAndFlush(userRole);

				// create student
				u.setCoursaId(cu.getId());
				u = universityRepo.saveAndFlush(university);
			}

		} else {
			System.out.println("Student found : " + u);
		}
		return u;
	}

}
