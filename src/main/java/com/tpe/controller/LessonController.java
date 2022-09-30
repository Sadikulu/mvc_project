package com.tpe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tpe.domain.Lesson;
import com.tpe.service.LessonService;

@Controller  //-->RestController
@RequestMapping("/lessons")
public class LessonController {
	
	@Autowired
	private LessonService lessonService;

	@GetMapping("/hello")
	public ModelAndView sayHi() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Hi lesson controller");
		mav.addObject("messagebody","I am lesson management system");
		mav.addObject("name", "Erdal Ismail Sadik Kayra");
		mav.addObject("lesson","Spring MVC");
		mav.setViewName("hi");
		return mav;
	}
	
	
	@GetMapping("/new")
	public String sendLessonForm(@ModelAttribute("lesson") Lesson lesson) {
		return "lessonForm"; //studentForm bir view name
	}
	
	
	@PostMapping("/saveLesson")
	public String createLesson(@Valid @ModelAttribute Lesson lesson, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "lessonForm";
		}
		lessonService.saveLesson(lesson);
		return "redirect:/lessons";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
		Lesson lesson= lessonService.findLessonById(id);
	    model.addAttribute("lesson",lesson);
	    return "lessonForm";
	
	}
	
//	@GetMapping("/delete")
//	//delete?id=1
//	public String deleteStudent(@RequestParam("id") Long id) {
//		studentService.deleteStudent(id);
//		return "redirect:/students";
//	}
	
	@GetMapping("/delete/{id}")
	//delete/1
	public String deleteLessonWithPath(@PathVariable Long id) {
		lessonService.deleteLesson(id);
		return "redirect:/lessons";
	}
	
	
	@GetMapping
	public ModelAndView getLessons() {
		List<Lesson> list= lessonService.getAllLesson();
		ModelAndView mav=new ModelAndView();
		mav.addObject("lessons",list);
		mav.setViewName("lessons");
		return mav;
	}
	
	@GetMapping("/rest-service")
	@ResponseBody
	public List<Lesson> getLessonsWithService() {
		List<Lesson> list= lessonService.getAllLesson();
		return list;
	}
	
//	@GetMapping("/rest-service/lessons/{id}")
//	@ResponseBody
//	public StudentDTO getLessonsWithService(@PathVariable Long id) {
//		Lesson lesson=lessonService.findLessonById(id);
//		StudentDTO lessonDTO=new StudentDTO(lesson.getName(),lesson.getPage());
//		return lessonDTO;
//	}
	
	@PostMapping("/rest-service/lessons")
	@ResponseBody
	public Map<String,String> saveLesson(@RequestBody Lesson lesson) {
		  lessonService.saveLesson(lesson);
		  Map<String,String> map=new HashMap<>();
		  map.put("message","Lesson saved successfuuly");
		  map.put("success", "true");
		  return map;
	}
	
	
}
