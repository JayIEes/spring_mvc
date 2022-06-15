package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

//annotation�� �����Ǿ� �־�� HandlerMapper�� class�� ã�� �� �ִ�. (component-scan)
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
		System.out.println("/multi.do��û");
		return "multi_result";
	}
	
	
	/**
	 * �پ��� ��û URL�� �ϳ��� method���� ó��
	 * @return View��������
	 */
	@RequestMapping(value={"/a.do","/b.do","/c.do"},method= {GET,POST})
	public String multiRequest() {
		
		return "multi_request";
	}//multiRequest
	
	
	@RequestMapping(value="/sub_result.do",method={GET,POST})
	public String resultMethod() {
		//return "sub_result";//WEB-INF/views/sub_result.jsp
		
		//views�� ���� ��ΰ� ������ ������ ���� ��θ� ����Ͽ� JSP�� ��û�ǵ��� ó��
		return "day0510/sub_result";//WEB-INF/views/day0510/sub_result.jsp 
	}
	
	
	/**
	 * ��û URL�� ���� JSP���� ���ٸ� method�� ��ȯ���� void�� ������ �� �ִ�.
	 */
	@RequestMapping(value="/void_return.do",method=GET)
	public void voidReturn() {
		System.out.println("void_return.do ȣ��");
	}
	
	
	
}
