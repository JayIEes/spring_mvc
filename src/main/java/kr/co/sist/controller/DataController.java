package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sist.service.DataService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller에서 처리된 데이터를 JSP로 보내기 위한 객체 사용.
 * @author user
 */
@Controller
public class DataController {

	//<a href="day0512/use_request.do">
	@RequestMapping(value="/day0512/use_request.do",method=GET) //value="day0512/use_request.do" - 하위 요청 묶을 수 있는 상위 개념으로 
	public String useRequest(HttpServletRequest request) {
		
		//업무 로직을 처리하는 클래스를 사용.
		DataService ds=new DataService();
		List<String> list=ds.searchData();
		
		//처리된 결과를 JSP로 전달하기 위해 SCOPE 객체 사용.
		request.setAttribute("data", list);
		request.setAttribute("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		return "day0512/use_request";
	}

	
	
	@RequestMapping(value="/day0512/use_model.do",method=GET)
	public String useModel(Model model) {
		
		//업무 로직 처리
		DataService ds=new DataService();
		
		//업무처리 결과를 model에 저장
		model.addAttribute("search_data",ds.searchData());
		model.addAttribute("search_date",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		model.addAttribute("user_name","지숙");
		
		
		return "day0512/use_model";
	}
	
	
	
	@RequestMapping(value="/day0512/use_model_and_view.do",method=GET)
	public ModelAndView useModelAndView() {
		
		//업무 로직 처리
		DataService ds=new DataService();
		
		//업무처리 결과를 ModelAndView에 저장
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("search_data",ds.searchData());
		mav.addObject("search_date",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		mav.addObject("user_name","지숙");
		
		//view page명을 설정
		mav.setViewName("day0512/use_model_and_view");
		
		return mav;
	}
	
	
	
}
