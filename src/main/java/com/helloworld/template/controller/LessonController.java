package com.helloworld.template.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.helloworld.template.entity.Lesson;
import com.helloworld.template.service.LessonService;

@Controller
@RequestMapping("/lesson")
public class LessonController {
	
	private static final Logger logger = Logger.getLogger(LessonController.class);
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("/query")
	public String query(@ModelAttribute Lesson lesson, Model model){
		String name = lesson.getName();
		if(name == null || name.trim().equals("")){
			model.addAttribute("errorMsg", "课程名不能为空！");
		}else{
			name= name.trim();
			logger.info("查询课程信息名称：" + name);
			List<Lesson> result = lessonService.getLessonByName(name);
			if(result == null)
				model.addAttribute("errorMsg", "没有相关课程信息");
			else
				model.addAttribute("result", result);
		}
		return "lesson";
	}

}
