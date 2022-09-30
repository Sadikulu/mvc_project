package com.tpe.repository;

import java.util.List;

import com.tpe.domain.Teacher;

public interface TeacherRepository {

	List<Teacher> getAll();
	Teacher findById(Long id);
	void save(Teacher teacher);
	void update(Teacher teacher);
	void delete(Long id);
}
