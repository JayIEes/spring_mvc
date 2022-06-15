package kr.co.sist.controller.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


import kr.co.sist.service.mybatis.ExamService;

@Controller
public class MyBatisController {

	@Autowired(required=false)
	private ExamService es;
	
	@RequestMapping(value = "/mybatis/mybatis_index.do", method = {GET,POST})
	public String myBatisJobList() {
		
		return "mybatis/index";
	}
	
	@RequestMapping(value = "/mybatis/day0523/scsrFrm.do", method = GET)
	public String scsrFrm() {
		return "mybatis/day0523/scsrFrm";
	}
	
	
	
	@RequestMapping(value = "/mybatis/day0523/scsrFrmProcess.do", method = POST)
	public String scsrFrmProcess(@RequestParam(defaultValue ="0" ) int deptno, Model model) throws NumberFormatException{ 
		//입력값을 업무로직 처리 클래스에 할당한다.
		String dname=es.scsr(deptno);
		System.out.println("Afsdf");
		
		
		//처리 결과를 view로 전달
		model.addAttribute("dname",dname);
		
		return "mybatis/day0523/scsrFrmProcess";
	}
	
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView processExceptionNumberFormat(NumberFormatException ne) {
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("err/number_format");
		mav.addObject("msg",ne.getMessage());
				
		return mav;
	}
	
	
	
}//class
