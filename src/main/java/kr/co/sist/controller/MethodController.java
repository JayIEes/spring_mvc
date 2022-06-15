package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

//annotation이 설정되어 있어야 HandlerMapper가 class를 찾을 수 있다. (component-scan)
@Controller
public class MethodController {
	@RequestMapping(value="/get.do",method=RequestMethod.GET)
	public String getMethod() {
		return "get_result";
	}
	
	@RequestMapping(value="/post.do",method=RequestMethod.POST)
	public String postMethod() {
		return "post_result";
	}
	
	@RequestMapping(value="/multi.do",method= {GET,POST})
	public String getPostMethod() {
		System.out.println("/multi.do요청");
		return "multi_result";
	}
	
	
	/**
	 * 다양한 요청 URL을 하나의 method에서 처리
	 * @return View페이지명
	 */
	@RequestMapping(value={"/a.do","/b.do","/c.do"},method= {GET,POST})
	public String multiRequest() {
		
		return "multi_request";
	}//multiRequest
	
	
	@RequestMapping(value="/sub_result.do",method={GET,POST})
	public String resultMethod() {
		//return "sub_result";//WEB-INF/views/sub_result.jsp
		
		//views에 하위 경로가 존재할 때에는 하위 경로를 기술하여 JSP가 요청되도록 처리
		return "day0510/sub_result";//WEB-INF/views/day0510/sub_result.jsp 
	}
	
	
	/**
	 * 요청 URL과 응답 JSP명이 같다면 method의 반환형을 void로 설정할 수 있다.
	 */
	@RequestMapping(value="/void_return.do",method=GET)
	public void voidReturn() {
		System.out.println("void_return.do 호출");
	}
	
	
	
}
