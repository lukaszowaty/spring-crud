package com.lukaszowaty.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lukaszowaty.dao.InstructorDAO;
import com.lukaszowaty.model.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorDAO instructorDAO;
	
	@Override
	@Transactional
	public List<Instructor> getInstructors() {
		return instructorDAO.getInstructors();
	}

	@Override
	@Transactional
	public void saveInstructor(Instructor instructor) {
		instructorDAO.saveInstructor(instructor);
		
	}

	@Override
	@Transactional
	public Instructor getInstructor(int id) {
		return instructorDAO.getInstructor(id);
	}

	@Override
	@Transactional
	public void deleteInstructor(int id) {
		instructorDAO.deleteInstructor(id);
		
	}

}
