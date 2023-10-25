package com.rajan.helloworld.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveEmployee(Employee emp) {
		Session session=getSessionFactory().openSession();
		session.save(emp);
		session.flush();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery("from Employee");
		empList = (List<Employee>) query.list();
		session.close();
		return empList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
