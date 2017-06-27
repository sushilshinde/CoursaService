package com.coursa.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface CoursaAPI<O>{
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public List<O> getAll();
	
	@RequestMapping(value = "/",method = RequestMethod.POST)		
	public O add(O object);
	
	@RequestMapping(value = "/",method = RequestMethod.PUT)		
	public O update(O object);
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)		
	public String delete(Long id);

}
