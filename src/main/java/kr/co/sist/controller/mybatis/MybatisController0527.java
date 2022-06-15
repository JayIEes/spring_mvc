package kr.co.sist.controller.mybatis;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.JoinDomain;
import kr.co.sist.service.mybatis.ExamService0526;
import kr.co.sist.service.mybatis.ExamService0527;
import kr.co.sist.vo.DynamicVO;
import kr.co.sist.vo.EmpVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@Controller
public class MybatisController0527 {
	
	
	@Autowired(required = false)
	private ExamService0527 es;
	
	
	@RequestMapping(value="mybatis/day0527/dynamicChoose.do",method=GET)
	public String dynamicChoose(Model model,DynamicVO dVO) {
		
		model.addAttribute("empList",es.dynamicChoose(dVO));
		
		return "mybatis/day0527/dynamicChoose";
	}
	
	
	@RequestMapping(value="mybatis/day0527/dynamicTrim.do",method=GET)
	public String dynamicTrim(Model model,DynamicVO dVO) {
		
		model.addAttribute("empList",es.dynamicTrim(dVO));
		
		return "mybatis/day0527/dynamicTrim";
	}
	
	
	
	@RequestMapping(value="mybatis/day0527/dynamicSet.do",method=GET)
	public String dynamicSet(Model model,EmpVO eVO) {
		
		if(eVO.getEmpno()!=0) {
		model.addAttribute("empBoolean",es.dynamicSet(eVO));
		}
		return "mybatis/day0527/dynamicSet";
	}
	
	
	
}
