package com.ruby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.rubypaper.student.StudentService;
import com.rubypaper.student.StudentVO;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student/")
@Controller
public class StudentController {
	@Autowired
	StudentService service;
	
	StudentController(){
		System.out.println("StudentController 생성자");
	}
	
	
	@GetMapping("list")
	public void select(Model model,StudentVO vo) {
		System.out.println("===> select");	
		model.addAttribute("li",service.select(vo));
	}
	
	
}
