package com.lukaszowaty.dao;

import java.util.List;

import com.lukaszowaty.model.Instructor;

public interface InstructorDAO {

	public List<Instructor> getInstructors();

	public void saveInstructor(Instructor instructor);

	public Instructor getInstructor(int id);

	public void deleteInstructor(int id);
	
	
}
