package com.lukaszowaty.service;

import java.util.List;

import com.lukaszowaty.model.Instructor;

public interface InstructorService {
	
	public List<Instructor> getInstructors();

	public void saveInstructor(Instructor instructor);

	public Instructor getInstructor(int id);

	public void deleteInstructor(int id);
}
