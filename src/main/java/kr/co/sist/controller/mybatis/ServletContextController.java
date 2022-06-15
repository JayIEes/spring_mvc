package kr.co.sist.controller.mybatis;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServletContextController {
	//DD의 <context-param>의 값을 얻기 위해 ServletContext를 의존성 주입받는다.
	@Autowired
	 ServletContext sc;
	
	
	@RequestMapping(value="mybatis/day0531/servletContext.do", method=RequestMethod.GET)
	public String useServletContext(Model model) {
		
		String protocol=sc.getInitParameter("protocol");
		String serverName=sc.getInitParameter("serverName");
		String commonCss=sc.getInitParameter("commonCss");
		String commonImages=sc.getInitParameter("commonImages");
		System.out.println("=============="+protocol);
		model.addAttribute("protocal",protocol);
		model.addAttribute("serverName",serverName);
		model.addAttribute("commonCss",commonCss);
		model.addAttribute("commonImages",commonImages);
		
		return "mybatis/day0531/servletContext";
				
	}
	
}
