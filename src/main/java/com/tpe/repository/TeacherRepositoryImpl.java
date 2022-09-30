package com.tpe.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tpe.domain.Teacher;

@Repository
@Component
public class TeacherRepositoryImpl implements TeacherRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Teacher> getAll() {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		List<Teacher> listOfTeachers= session.createQuery("FROM Teacher",Teacher.class).getResultList();
		tx.commit();
		session.close();
		return listOfTeachers;
	}

	@Override
	public Teacher findById(Long id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Teacher teacher= session.get(Teacher.class, id);
		tx.commit();
		session.close();
		return teacher;
	}

	@Override
	public void save(Teacher teacher) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(teacher);
		tx.commit();
		session.close();		
	}

	@Override
	public void update(Teacher teacher) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.update(teacher);
		tx.commit();
		session.close();	
	}

	@Override
	public void delete(Long id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		
		Teacher teacher=session.load(Teacher.class, id);
		session.delete(teacher);
		tx.commit();
		session.close();
		
	}
}
