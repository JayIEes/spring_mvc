package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class MoveController {
	
	@RequestMapping(value="/day0512/do_move.do",method=GET)
	public String doMove() {
		System.out.println("do�� ���û ������");
		
		//return "../index.do"; //ViewResolver�� ���� => WEB-INF/views/../index.do.jsp
		return "redirect:/index.do"; //ViewResolver�� ���� ����
	}
	
	
	@RequestMapping(value="/day0512/jsp_move.do",method=GET)
	public String jspMove() {
		System.out.println("jsp�� ���û ������");
		
		//return "../index.do"; //ViewResolver�� ���� => WEB-INF/views/../index.do.jsp
		return "redirect:http://localhost/spring_mvc/jsp_result.jsp"; //ViewResolver�� ���� ����
	}
	
	
	
	@RequestMapping(value="/day0512/forward_a.do",method=GET)
	public String doDirectMove() { //forward�� ��û�� �� �̵��� �������� forward�� ��û ����� ����
		System.out.println("do�� ���� ��û ������");
		
		//do�� ���� ��û
		return "forward:forward_b.do";//ViewResolver�� ���� ���� 
	}
	
	
	
	@RequestMapping(value="/day0512/forward_b.do",method=GET)
	public String doDirectMoveB() { //forward�� ��û�� �� �̵��� �������� forward�� ��û ����� ����
		System.out.println("����");
		
		return "day0512/forward_b_result";//ViewResolver�� ����� �̵�. WEB-INF/views
	}
	
	
	
}
