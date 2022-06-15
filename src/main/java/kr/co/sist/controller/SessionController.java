package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.service.DataService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author user
 * session 사용
 */
@Controller
@SessionAttributes({"sesName","sesAge"})
public class SessionController {
	
	@RequestMapping(value="/day0512/session.do",method=GET)
	public String useSession(HttpSession session) {
		System.out.println(session);
		//세션에 값 설정
		session.setAttribute("name", "서지숙");
		
		DataService ds=new DataService();
		session.setAttribute("data", ds.searchData());
		
		System.out.println(session.getAttribute("name"));
		return "day0512/use_session";
	}
	
	
	@RequestMapping(value="/day0513/set_session.do",method=GET)
	public String setSessionValue(Model model) {
		//model에 @SessionAttribute과 같은 이름으로 값을 설정.
		model.addAttribute("sesName","지숙");
		model.addAttribute("sesAge","27");
		
		return "day0513/set_session"; 
	}//setSessionValue
	
	
	/**
	 * 세션에 설정된 값 받기
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/day0513/get_session.do",method=GET)
	public String getSessionValue(HttpSession session) {

		String sesName=(String)session.getAttribute("sesName");
		
		String url="day0513/get_session";
		
		if(sesName==null) {
			url="redirect:http://localhost/spring_mvc/index.do";
		}else {
			System.out.println(sesName);
			System.out.println(session.getAttribute("sesAge"));
		}
		
		
		return url; 
	}//setSessionValue
	
	
	
	
	
	@RequestMapping(value="/day0513/remove_session.do",method=GET)
	public String removeSession(SessionStatus ss) {
		System.out.println("삭제 전 : "+ss.isComplete());
		ss.setComplete();
		System.out.println("삭제 후 : "+ss.isComplete());
		
//	public String removeSession(HttpSession session) { //HttpSession으로는 값을 삭제할 수 없다.
//		session.removeAttribute("sesName");
//		session.removeAttribute("sesAge");
//		System.out.println("세션 삭제");
//		System.out.println("이름"+session.getAttribute("sesName"));
//		System.out.println("나이"+session.getAttribute("sesAge"));
//		
//		return "day0513/remove_session";
		return "day0513/remove_session";
	}
	
	
	@RequestMapping(value="/day0513/add_cookie.do",method=GET)
	public String addCookie(HttpServletResponse response) {
		
		//쿠키 생성
		Cookie cookie=new Cookie("name","테스트");
		Cookie cookie2=new Cookie("addr","서울시");
		
		//생존시간 설정
		cookie.setMaxAge(60*60*1);
		cookie2.setMaxAge(60*60*1);
		
		//쿠키심기
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		return "day0513/add_cookie";
	}
	
	
	@RequestMapping(value="day0513/get_cookie.do",method=GET)
	public String getCookieValue(@CookieValue(value="name",defaultValue="이름없음")String name, @CookieValue(value="addr",defaultValue="주소없음")String addr) {
		System.out.println("name 쿠키 값:"+name);
		System.out.println("age 쿠키 값:"+addr);
		
		return "day0513/get_cookie";
	}
	
	
	
	@RequestMapping(value="/day0513/remove_cookie.do",method=GET)
	public String removeCookie(HttpServletResponse response) {
		
		//쿠키 생성
		Cookie cookie=new Cookie("name","");
		Cookie cookie2=new Cookie("addr","");
		
		//생존시간 설정
		cookie.setMaxAge(0);
		cookie2.setMaxAge(0);
		
		//쿠키심기
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		return "day0513/get_cookie";
	}
	
	

	
	
	
}//class
