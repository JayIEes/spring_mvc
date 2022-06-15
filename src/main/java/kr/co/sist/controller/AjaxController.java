package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.service.AjaxService;

@Controller
public class AjaxController {

	@RequestMapping(value="/day0513/ajax.do",method=RequestMethod.GET)
	public String ajax(Model model) {
		
		AjaxService as=new AjaxService();
		model.addAttribute("data",as.createJSON());
		
		return "day0513/ajax_result";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/day0516/ajax.do",method=RequestMethod.GET, 
						produces="application/json;charset=UTF-8")
	public String ajax1() {
		
		AjaxService as=new AjaxService();
		//@ResponseBody가 정의되면 View페이지명이 아닌 JSON이 return되어야한다.
		
		return as.createJSON();
	}
	
}
