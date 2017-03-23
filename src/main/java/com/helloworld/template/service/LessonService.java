package com.helloworld.template.service;

import java.util.List;

import com.helloworld.template.entity.Lesson;

public interface LessonService {
	
	List<Lesson> getLessonByName(String name);

}
