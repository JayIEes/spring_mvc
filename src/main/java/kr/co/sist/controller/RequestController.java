package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.vo.ParamVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RequestController {

	@RequestMapping(value="/req_info.do",method=GET)
	public String reqInfo(HttpServletRequest request) {
		String ip=request.getRemoteAddr();
		
		System.out.println("������ip"+ip);
		System.out.println("��û���"+request.getMethod());
		System.out.println("��ûURL"+request.getRequestURL());
		System.out.println("��ûURI"+request.getRequestURI());
		//System.out.println("��û���"+request.getHeaderNames());
		
		Enumeration<String> en=request.getHeaderNames();
		String headerName="";
		
		while(en.hasMoreElements()) {
			headerName=en.nextElement();
			System.out.println(headerName+" : "+request.getHeader(headerName));
		}
		
		
		if("211.63.89.133".equals(ip)) { //������ ���� ����  
			System.out.println("����");
		}//end if
		
		
		return "day0511/req_info";
	}//reqInfo
	
	
	
	
	/**
	 * HttpServletRequest�� ����� Web Parameter ó��
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/use_request.do",method=GET)
	public String useRequest(HttpServletRequest request) {
		
		request.setAttribute("msg", "/use_request.do�� ȣ��");
		
		//�̸��� ����
		String name=request.getParameter("name");
		String age=request.getParameter("age");
		
		//�̸� �ߺ�
		String[] lang=request.getParameterValues("lang");
		
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+age);
		System.out.println("��� : ");
		if(lang!=null) {
			for(String temp : lang) {
				System.out.println(temp);
			}//end for
		}
		
		
		return "day0511/use_request";
	}

	
	
	/**
	 * ���������� �� �Ķ���� �ޱ�<br/>
	 * �� �Ķ���� ��� method�� �Ķ���� ���� �ݵ�� ��ġ�ؾ� �Ѵ�.
	 * @param name
	 * @param age
	 * @param lang
	 * @return
	 */
	@RequestMapping(value="/single_param.do")
	//public String useSingleParam(String name, String age, String[] lang, Model model) {
	public String useSingleParam(String name, @RequestParam(defaultValue="0") int age, String[] lang, Model model) {
		//Web Parameter�� ���ڿ��θ� ���޵����� �Ű������� ���������� �⺻������ �����ϸ� 
		//Spring Framework���� ����ȯ�� �����Ͽ� �Է����ش�. 
		
		
		model.addAttribute("msg","/single_param.do�� ȣ��");
		
		System.out.println("������ ������������ �Ű����� ó��");
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+age+"/"+(2022-age+1));
		System.out.println("��� : ");
		if(lang!=null) {
			for(String temp : lang) {
				System.out.println(temp);
			}//end for
		}
		
		
		return "day0511/use_request";
	}
	
	
	
	@RequestMapping(value="/vo_param.do",method= {GET,POST})
	public String paramVO( ParamVO pVO,Model model) {
		//Post����� �ѱ� ó��
		
		model.addAttribute("msg","/vo_param.do");
		
		System.out.println(pVO);
		return "day0511/use_request";
	}
	
}







