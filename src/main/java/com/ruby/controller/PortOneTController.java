package com.ruby.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rubypaper.board.BoardService;
import com.rubypaper.portoneT.PortOneTService;
import com.rubypaper.portoneT.PortOneTVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@RequestMapping("/PortOneT/")
@Controller
public class PortOneTController {
	@Autowired
	PortOneTService service;
	
	PortOneTVO vo1 = new PortOneTVO();
    
    PortOneTController(){
    	System.out.println("PortOneTController 생성자");
    }
    
    @GetMapping("start")
    public void start(PortOneTVO vo,Model model) {
    	System.out.println("===> start");
    	vo.setGname("지헬스클럽");
    	vo.setGymnum("90001");
    	vo.setMembernum("10001");
    	vo.setMmail("wlgml625@naver.com");
    	vo.setMname("서지희");
    	vo.setMphone("01034471872");
    	vo.setDataGoodsnum("7001");
    	vo.setDataPrice(100);
    	vo.setDataName("헬스3개월");
    	Date now = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
		String k = sdf.format(now);
    	vo.setToday(k);
    	System.out.println("===> "+vo);
    	model.addAttribute("m", vo);
    }
    
    @PostMapping("insertMPay")
    @ResponseBody
    public String insertMPay(@RequestBody PortOneTVO vo,Model model){
       System.out.println("===> insertMPay "+vo+":"+vo1);
       	vo1.setMpaynum(vo.getMpaynum()); 
       	
       String OK = service.insert(vo);
       
        return OK;
    }
    
    @GetMapping("result")
    public String result(Model model,PortOneTVO vo,HttpServletRequest request){
       System.out.println("===> result "+vo);
       model.addAttribute("vo1", vo1); //2)db사용하지 않고 불러오기(전역변수)
       model.addAttribute("li",service.select(vo)); //1)db값중 max값 불러오기
       //vo.setMpaynum(vo1.getMpaynum());
       model.addAttribute("edit", service.edit(vo)); //3)db에서 mpaynum값으로 찾기(전역변수)
       model.addAttribute("hello","hello");
       return "/PortOneT/result.html";
    }
    
    @GetMapping("fail")
    public String fail(Model model){
       System.out.println("===> fail");
       model.addAttribute("fail","fail");
       return "/PortOneT/fail.html";
    }
    
    
}
