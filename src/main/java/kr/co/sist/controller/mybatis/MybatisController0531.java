package kr.co.sist.controller.mybatis;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.JoinDomain;
import kr.co.sist.service.mybatis.ExamService0526;
import kr.co.sist.service.mybatis.ExamService0527;
import kr.co.sist.service.mybatis.ExamService0530;
import kr.co.sist.service.mybatis.ExamService0531;
import kr.co.sist.vo.DynamicVO;
import kr.co.sist.vo.EmpVO;
import kr.co.sist.vo.ForeachVO;
import kr.co.sist.vo.InsertVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@Controller
public class MybatisController0531 {
	
	
	@Autowired(required = false)
	private ExamService0531 es;
	
	
	@RequestMapping(value="mybatis/day0531/selectProc.do",method=GET)
	public String searchAllTestProcedure(Model model) {
		
		model.addAttribute("searchData",es.searchAllProcedure());
		
		return "mybatis/day0531/selectProc";
	}
	
	
	@RequestMapping(value="mybatis/day0531/selectProc2.do",method=GET)
	public String searchNumTestProcedure(Model model,@RequestParam(defaultValue = "0") int num) {
		
		if(num!=0) {
			model.addAttribute("searchData",es.searchNumTestProcedure(num));
		}
		
		return "mybatis/day0531/selectProc2";
	}
	
	
}
