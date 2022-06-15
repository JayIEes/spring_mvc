package kr.co.sist.controller.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.service.mybatis.ExamService0524;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MybatisController0524 {
	
	
	@Autowired(required = false)
	private ExamService0524 es;
	
	
	
	@RequestMapping(value="mybatis/day0524/scmrFrmProcess.do",method=GET)
	public String scmr(Model model,@RequestParam(defaultValue ="-1") int deptno) {
		
		if(deptno!=-1){
			List<String> list=es.scmr(deptno);
			model.addAttribute("enameList",list);
		}
		
		return "mybatis/day0524/scmrFrmProcess";
	}
	
	
	
	
	
	@RequestMapping(value="mybatis/day0524/mcsrFrmProcess.do",method=GET)
	public String mcsr(Model model,@RequestParam(defaultValue ="-1") int empno) {
		
		if(empno!=-1) {
			model.addAttribute("empData",es.mcsr(empno));
		}
		
		return "mybatis/day0524/mcsrFrmProcess";
	}
	
	
	@RequestMapping(value="mybatis/day0524/mcmrFrmProcess.do",method=GET)
	public String mcmr(Model model,@RequestParam(defaultValue ="-1") int deptno) {
		
		if(deptno!=-1) {
			model.addAttribute("empList",es.mcmr(deptno));
		}
		
		return "mybatis/day0524/mcmrFrmProcess";
	}
	
	
	
	@RequestMapping(value="mybatis/day0524/ltFrmProcess.do",method=GET)
	public String lessThan(Model model,@RequestParam(defaultValue ="-1") int sal) {
		
		if(sal!=-1) {
			model.addAttribute("empList",es.lessThan(sal));
		}
		
		return "mybatis/day0524/ltFrmProcess";
	}
	
	
	
}
