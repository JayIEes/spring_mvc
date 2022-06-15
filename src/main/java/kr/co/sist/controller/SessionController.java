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
 * session ���
 */
@Controller
@SessionAttributes({"sesName","sesAge"})
public class SessionController {
	
	@RequestMapping(value="/day0512/session.do",method=GET)
	public String useSession(HttpSession session) {
		System.out.println(session);
		//���ǿ� �� ����
		session.setAttribute("name", "������");
		
		DataService ds=new DataService();
		session.setAttribute("data", ds.searchData());
		
		System.out.println(session.getAttribute("name"));
		return "day0512/use_session";
	}
	
	
	@RequestMapping(value="/day0513/set_session.do",method=GET)
	public String setSessionValue(Model model) {
		//model�� @SessionAttribute�� ���� �̸����� ���� ����.
		model.addAttribute("sesName","����");
		model.addAttribute("sesAge","27");
		
		return "day0513/set_session"; 
	}//setSessionValue
	
	
	/**
	 * ���ǿ� ������ �� �ޱ�
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
		System.out.println("���� �� : "+ss.isComplete());
		ss.setComplete();
		System.out.println("���� �� : "+ss.isComplete());
		
//	public String removeSession(HttpSession session) { //HttpSession���δ� ���� ������ �� ����.
//		session.removeAttribute("sesName");
//		session.removeAttribute("sesAge");
//		System.out.println("���� ����");
//		System.out.println("�̸�"+session.getAttribute("sesName"));
//		System.out.println("����"+session.getAttribute("sesAge"));
//		
//		return "day0513/remove_session";
		return "day0513/remove_session";
	}
	
	
	@RequestMapping(value="/day0513/add_cookie.do",method=GET)
	public String addCookie(HttpServletResponse response) {
		
		//��Ű ����
		Cookie cookie=new Cookie("name","�׽�Ʈ");
		Cookie cookie2=new Cookie("addr","�����");
		
		//�����ð� ����
		cookie.setMaxAge(60*60*1);
		cookie2.setMaxAge(60*60*1);
		
		//��Ű�ɱ�
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		return "day0513/add_cookie";
	}
	
	
	@RequestMapping(value="day0513/get_cookie.do",method=GET)
	public String getCookieValue(@CookieValue(value="name",defaultValue="�̸�����")String name, @CookieValue(value="addr",defaultValue="�ּҾ���")String addr) {
		System.out.println("name ��Ű ��:"+name);
		System.out.println("age ��Ű ��:"+addr);
		
		return "day0513/get_cookie";
	}
	
	
	
	@RequestMapping(value="/day0513/remove_cookie.do",method=GET)
	public String removeCookie(HttpServletResponse response) {
		
		//��Ű ����
		Cookie cookie=new Cookie("name","");
		Cookie cookie2=new Cookie("addr","");
		
		//�����ð� ����
		cookie.setMaxAge(0);
		cookie2.setMaxAge(0);
		
		//��Ű�ɱ�
		response.addCookie(cookie);
		response.addCookie(cookie2);
		
		return "day0513/get_cookie";
	}
	
	

	
	
	
}//class
