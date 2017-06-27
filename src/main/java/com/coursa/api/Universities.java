package com.coursa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coursa.domain.University;
import com.coursa.services.UniversityService;

@RestController()
@RequestMapping("/universities")
public class Universities implements CoursaAPI<University> {
	
	@Autowired
	UniversityService service;

	@Override	
	public List<University> getAll() {	
		System.out.println("getAll");
		return this.service.getAllUniversties();
	}

	@Override
	public University add(@RequestBody University university) {
		return this.service.create(university);
	}

	@Override
	public University update(@RequestBody University university) {
		return null;
	}

	@Override
	public String delete(Long id) {
		
		return "University deleted";
	}
}