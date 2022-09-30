package com.tpe.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tpe.domain.Teacher;
import com.tpe.service.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	

	@GetMapping("/hello")
	public ModelAndView sayHi() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("message","Hi");
		mav.addObject("messagebody","I am teacher management system");
		mav.setViewName("hi");
		return mav;
	}
	
	
	@GetMapping("/new")
	public String sendTeacherForm(@ModelAttribute("teacher") Teacher teacher) {
		return "teacherForm"; //teacherForm bir view name
	}
	
	
	@PostMapping("/saveTeacher")
	public String createTeacher(@Valid @ModelAttribute Teacher teacher, BindingResult bindingResult) {
		//validation
		if(bindingResult.hasErrors()) {
			return "teacherForm";
		}
		
		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("id") Long id, Model model) {
		Teacher teacher= teacherService.findTeacherById(id);
	    model.addAttribute("teacher",teacher);
	    return "teacherForm";
	
	}
	
	@GetMapping("/delete")
	public String deleteTeacher(@RequestParam("id") Long id) {
        teacherService.deleteTeacher(id);
	    
	    return "redirect:/teachers";
	
	}
	
	
	@GetMapping
	public ModelAndView getTeacher() {
		List<Teacher> list= teacherService.getAllTeacher();
		ModelAndView mav=new ModelAndView();
		mav.addObject("teachers",list);
		mav.setViewName("teachers");
		return mav;
	}
}
