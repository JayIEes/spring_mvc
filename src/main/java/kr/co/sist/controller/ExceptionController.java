package kr.co.sist.controller;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	
	/**
	 * Controller의 요청 method에서 예외가 발생하면 DispatcherServlet에서 예외를 잡는다.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/day0516/use_exception.do", method=RequestMethod.GET)
	public String useMethod() throws Exception {
		
		//Service를 사용했을 때 예외가 발생한다는 가정
		if(new Random().nextBoolean()) {
			throw new Exception("Service에서 발생된 예외");
		}
		
		return "day0516/success";
	}
	
	
	//SQLException을 throws 하는 예외를 처리하는 ExceptionHandler 작성
	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlExceptionHandler(SQLException se) {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("err/sql_err");
		mav.addObject("err_msg",se.getMessage());
		
		return mav;
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	//반환형이 ModelAndView, 매개변수는 ExceptionHandler에 정의된 예외처리 객체
	public ModelAndView exceptionHandler(Exception e, HttpServletRequest request) {
	
		ModelAndView mav=new ModelAndView();
		Enumeration<String> en=request.getHeaderNames();
		
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
		//e.printStackTrace();
		
		//예외가 발생했을 때 제공할 View페이지명
		mav.setViewName("err/err500");
		mav.addObject("err_msg",e.getMessage());
		mav.addObject("err_use-agent",request.getHeader("use-agent"));
		mav.addObject("referer",request.getHeader("referer"));
		
		
		return mav;
	}
	
}
