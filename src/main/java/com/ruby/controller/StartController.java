package com.ruby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.rubypaper.board.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StartController {
	@Autowired
	BoardService service;
	
	StartController(){
		System.out.println("StartController 생성자");
	}
	
	@GetMapping("/index")
	public void index() {
		System.out.println("===> index");
	}
	
	
}
