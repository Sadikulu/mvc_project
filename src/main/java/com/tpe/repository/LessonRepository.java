package com.tpe.repository;

import java.util.List;
import java.util.Optional;

import com.tpe.domain.Lesson;

public interface LessonRepository {

	List<Lesson> getAll();
	Optional<Lesson> findById(Long id);
	void save(Lesson lesson);
	void update(Lesson lesson);
	void delete(Long id);
}
