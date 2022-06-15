package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MoveController {
	
	@RequestMapping(value="/day0512/do_move.do",method=GET)
	public String doMove() {
		System.out.println("do로 재요청 보내기");
		
		//return "../index.do"; //ViewResolver가 동작 => WEB-INF/views/../index.do.jsp
		return "redirect:/index.do"; //ViewResolver의 동작 막기
	}
	
	
	@RequestMapping(value="/day0512/jsp_move.do",method=GET)
	public String jspMove() {
		System.out.println("jsp로 재요청 보내기");
		
		//return "../index.do"; //ViewResolver가 동작 => WEB-INF/views/../index.do.jsp
		return "redirect:http://localhost/spring_mvc/jsp_result.jsp"; //ViewResolver의 동작 막기
	}
	
	
	
	@RequestMapping(value="/day0512/forward_a.do",method=GET)
	public String doDirectMove() { //forward로 요청될 시 이동된 페이지도 forward로 요청 방식을 같게
		System.out.println("do로 직접 요청 보내기");
		
		//do를 직접 요청
		return "forward:forward_b.do";//ViewResolver의 동작 막기 
	}
	
	
	
	@RequestMapping(value="/day0512/forward_b.do",method=GET)
	public String doDirectMoveB() { //forward로 요청될 시 이동된 페이지도 forward로 요청 방식을 같게
		System.out.println("응답");
		
		return "day0512/forward_b_result";//ViewResolver를 사용한 이동. WEB-INF/views
	}
	
	
	
}
