package com.tpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpe.domain.Lesson;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.LessonRepository;

@Service
public class LessonServiceImpl implements LessonService{

	@Autowired
	private LessonRepository lessonRepository;
	
	@Override
	public List<Lesson> getAllLesson() {
		return lessonRepository.getAll();
	}

	@Override
	public Lesson findLessonById(Long id) {
		return lessonRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Lesson not found with id:"+id));
	}

	@Override
	public void saveLesson(Lesson lesson) {
		lessonRepository.save(lesson);
		
	}

	@Override
	public void updateLesson(Lesson lesson) {
		lessonRepository.update(lesson);
		
	}

	@Override
	public void deleteLesson(Long id) {
		lessonRepository.delete(id);
		
	}

}
