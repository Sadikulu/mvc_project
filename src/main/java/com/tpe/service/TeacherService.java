package com.tpe.service;

import java.util.List;

import com.tpe.domain.Teacher;

public interface TeacherService {

	List<Teacher> getAllTeacher();
	Teacher findTeacherById(Long id);
	void saveTeacher(Teacher teacher);
	void updateTeacher(Teacher teacher);
	void deleteTeacher(Long id);
}
