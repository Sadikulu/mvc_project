package com.tpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.tpe.domain.Teacher;
import com.tpe.repository.TeacherRepository;

@Service
@Component
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public List<Teacher> getAllTeacher() {
		return teacherRepository.getAll();
	}

	@Override
	public Teacher findTeacherById(Long id) {
		return teacherRepository.findById(id);
	}

	@Override
	public void saveTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		teacherRepository.update(teacher);
		
	}

	@Override
	public void deleteTeacher(Long id) {
       teacherRepository.delete(id);    		
	}


}
