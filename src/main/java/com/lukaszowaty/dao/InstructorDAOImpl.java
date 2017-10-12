package com.lukaszowaty.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lukaszowaty.model.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Instructor> getInstructors() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query - sort by last name
		Query<Instructor> query = currentSession.createQuery("from Instructor order by lastName", Instructor.class);
		
		// execute query and get result list
		List<Instructor> instructors = query.getResultList();
		
		// return the results
		
		return instructors;
	}

	@Override
	public void saveInstructor(Instructor instructor) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update the instructor 
		currentSession.saveOrUpdate(instructor);;
		
	}

	@Override
	public Instructor getInstructor(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrive/read from database using the primary key
		Instructor instructor = currentSession.get(Instructor.class, id);
		
		return instructor;
	}

	@Override
	public void deleteInstructor(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query query = currentSession.createQuery("delete from Instructor where id=:instructorId");
		query.setParameter("instructorId", id);
		query.executeUpdate();
		
	}

}
