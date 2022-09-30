package com.tpe.service;

import java.util.List;

import com.tpe.domain.Lesson;

public interface LessonService {

	List<Lesson> getAllLesson();
	Lesson findLessonById(Long id);
	void saveLesson(Lesson lesson);
	void updateLesson(Lesson lesson);
	void deleteLesson(Long id);
}
