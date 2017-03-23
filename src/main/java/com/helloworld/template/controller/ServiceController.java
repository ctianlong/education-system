package com.helloworld.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helloworld.template.entity.Lesson;

@Controller
@RequestMapping("/service")
public class ServiceController {
	
	@RequestMapping("/sayHello")
	@ResponseBody
	public Lesson sayHello(String name){
		Lesson lesson = new Lesson();
		lesson.setName(name);
		return lesson;
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public int add(int a, int b){
		return a + b;
	}

}
