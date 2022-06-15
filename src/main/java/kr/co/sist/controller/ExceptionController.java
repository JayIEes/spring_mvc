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
	 * Controller�� ��û method���� ���ܰ� �߻��ϸ� DispatcherServlet���� ���ܸ� ��´�.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/day0516/use_exception.do", method=RequestMethod.GET)
	public String useMethod() throws Exception {
		
		//Service�� ������� �� ���ܰ� �߻��Ѵٴ� ����
		if(new Random().nextBoolean()) {
			throw new Exception("Service���� �߻��� ����");
		}
		
		return "day0516/success";
	}
	
	
	//SQLException�� throws �ϴ� ���ܸ� ó���ϴ� ExceptionHandler �ۼ�
	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlExceptionHandler(SQLException se) {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("err/sql_err");
		mav.addObject("err_msg",se.getMessage());
		
		return mav;
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	//��ȯ���� ModelAndView, �Ű������� ExceptionHandler�� ���ǵ� ����ó�� ��ü
	public ModelAndView exceptionHandler(Exception e, HttpServletRequest request) {
	
		ModelAndView mav=new ModelAndView();
		Enumeration<String> en=request.getHeaderNames();
		
		while(en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
		//e.printStackTrace();
		
		//���ܰ� �߻����� �� ������ View��������
		mav.setViewName("err/err500");
		mav.addObject("err_msg",e.getMessage());
		mav.addObject("err_use-agent",request.getHeader("use-agent"));
		mav.addObject("referer",request.getHeader("referer"));
		
		
		return mav;
	}
	
}
