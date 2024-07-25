package com.ruby.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.rubypaper.board.BoardService;
import com.rubypaper.board.BoardVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/board/")
@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	BoardController(){
		System.out.println("BoardController 생성자");
	}
	
	@GetMapping("form")
	public void form() {
		System.out.println("===> form");
	}
	
	@PostMapping("insert")
	public String insert(BoardVO vo) {
		System.out.println("===> insert");
		service.insert(vo);
		return "redirect:/board/list";
	}
	
	@GetMapping("list")
	public void select(Model model,BoardVO vo) {
		System.out.println("===> select");	
		vo.setSearchKeyword("%" + vo.getSearchKeyword() +"%");
		model.addAttribute("li",service.select(vo));
		model.addAttribute("tc",service.tc(vo));
	}
	
	@GetMapping("edit")
	public void edit(Model model,BoardVO vo) {
		System.out.println("===> edit "+vo);
		model.addAttribute("m",service.edit(vo));
	}
	
	@GetMapping("delete")
	public String delete(BoardVO vo) {
		System.out.println("===> delete");
		service.delete(vo);
		return "redirect:/board/list";
	}
	
	@PostMapping("update")
	public String update(BoardVO vo) {
		System.out.println("===> update");
		service.update(vo);
		return "redirect:/board/list";
	}
	
}
