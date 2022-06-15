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
import kr.co.sist.vo.DynamicVO;
import kr.co.sist.vo.EmpVO;
import kr.co.sist.vo.ForeachVO;
import kr.co.sist.vo.InsertVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

@Controller
public class MybatisController0530 {
	
	
	@Autowired(required = false)
	private ExamService0530 es;
	
	
	@RequestMapping(value="mybatis/day0530/dynamicForeach.do",method=GET)
	public String dynamicForeach(Model model, ForeachVO fVO) {
		
		if(fVO.getDeptno()!=0) {
		model.addAttribute("empList",es.searchDynamicForeach(fVO));
		}
		
		return "mybatis/day0530/dynamicForeach";
	}
	
	
	
	
	@RequestMapping(value="mybatis/day0530/insertProc.do", method=GET)
	public String addProcedureForm(Model model,InsertVO iVO ) {
		
		if(iVO.getNum()!=0) {
			es.addProcedure(iVO);
			model.addAttribute("insertVO",iVO);
			}
		
		return "mybatis/day0530/insertProc";
	}
	
	
	
	@RequestMapping(value="mybatis/day0530/updateProc.do", method=GET)
	public String modifyProcedureForm(Model model,InsertVO iVO ) {
		
		if(iVO.getNum()!=0) {
			es.modifyProcedure(iVO);
			model.addAttribute("updateVO",iVO);
		}
		
		return "mybatis/day0530/updateProc";
	}
	
	
	@RequestMapping(value="mybatis/day0530/deleteProc.do", method=GET)
	public String removeProcedureForm(Model model,InsertVO iVO ) {
		
		if(iVO.getNum()!=0) {
			es.removeProcedure(iVO);
			model.addAttribute("removeVO",iVO);
		}
		
		return "mybatis/day0530/deleteProc";
	}
	
}
