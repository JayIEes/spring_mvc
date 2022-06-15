package kr.co.sist.controller.mybatis;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.JoinDomain;
import kr.co.sist.service.mybatis.ExamService0526;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@Controller
public class MybatisController0526 {
	
	
	@Autowired(required = false)
	private ExamService0526 es;
	

	
	@RequestMapping(value="mybatis/day0526/join.do",method=GET)
	public String join(Model model,String country, String searchFlag) {
		
		//view로 처리된 데이터 전달
		model.addAttribute("country",es.searchCountry());
		
		if(country!=null) {
			List<JoinDomain> list = "전체".equals(searchFlag)?es.join(country):es.subqueryJoin(country);
			
			model.addAttribute("carList",list);
			model.addAttribute("searchFlag",searchFlag);
		}//end if
		
		return "mybatis/day0526/join";
	}
	
	
	
	@RequestMapping(value="mybatis/day0526/dynamicTable.do",method=GET)
	public String dynamicTable(Model model,String tableName) {
		
		
		if(tableName!=null) {
			model.addAttribute("empList",es.dynamicTable(tableName));
		}//end if
		
		return "mybatis/day0526/dynamicTable";
	}
	

	
	
	@RequestMapping(value="mybatis/day0526/dynamicIf.do",method=GET)
	public String dynamicIf(Model model,String job) {
		
		
		model.addAttribute("empList",es.dynamicIf(job));
		model.addAttribute("jobs",es.jobList());
		
		return "mybatis/day0526/dynamicIf";
	}
	
	
	
}
