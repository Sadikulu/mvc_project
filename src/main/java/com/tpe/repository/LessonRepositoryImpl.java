package com.tpe.repository;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tpe.domain.Lesson;

@Repository
public class LessonRepositoryImpl implements LessonRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Lesson> getAll() {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		List<Lesson> listOfLesson= session.createQuery("FROM Lesson",Lesson.class).getResultList();
		tx.commit();
		session.close();
		return listOfLesson;
	}

	@Override
	public Optional<Lesson> findById(Long id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		Lesson lesson= session.get(Lesson.class, id);
		Optional<Lesson> opt=null;
		opt=Optional.ofNullable(lesson);
		tx.commit();
		session.close();
		return opt;
	}

	@Override
	public void save(Lesson lesson) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.saveOrUpdate(lesson);
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(Lesson lesson) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.update(lesson);
		tx.commit();
		session.close();
		
	}

	@Override
	public void delete(Long id) {
		Session session= sessionFactory.openSession();
		Transaction tx= session.beginTransaction();
		session.delete(id);
		tx.commit();
		session.close();
		
	}

}
