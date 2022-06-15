package kr.co.sist.controller.mybatis;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.service.mybatis.ExamService0525;
import kr.co.sist.vo.BoardVO;

@Controller
public class MyBatisController0525 {
	@Autowired(required = false)
	private ExamService0525 es;
	
	
	@RequestMapping(value="/mybatis/day0525/gtFrmProcess.do", method = GET)
	public String greaterThan(Model model, @RequestParam(defaultValue = "-1")int sal) {
		
		if( sal != -1) {
			model.addAttribute("empList", es.greaterThan(sal));
		}//end if
		
		return "mybatis/day0525/gtFrmProcess";
	}//greaterThan
	
	@RequestMapping(value="/mybatis/day0525/likeFrmProcess.do", method = GET)
	public String like(Model model, String option) {
		
		model.addAttribute("carList", es.like(option));
		
		return "mybatis/day0525/likeFrmProcess";
	}//like
	
	@RequestMapping(value="/mybatis/day0525/subquery.do", method = GET)
//	public String subquery(Model model, @RequestParam(defaultValue ="1" ) int currentPage) {
	//코드 개선 : 현재페이지에서 검색 컬럼과 키워드가 추가됨.
	public String subquery(Model model,BoardVO bVO) {
		
		//1. 전체레코드의 수
		int totalCnt=es.searchTotalCount(bVO);
		//2. 한 화면에 보여줄 게시물의 수
		int pageScale=es.pageScale();
		
		//3.총 페이지 수(몇장?)
		int pageCnt=es.pageCnt(totalCnt, pageScale);
		//4. 시작번호
		int startNum=es.startNum(bVO.getCurrentPage(), pageScale);
		//5. 끝번호
		int endNum=es.endNum(startNum, pageScale);
		
//		BoardVO bVO=new BoardVO(startNum, endNum);
		bVO.setStartNum(startNum);
		bVO.setEndNum(endNum);
		
		model.addAttribute("totalCnt",totalCnt);
		model.addAttribute("pageScale",pageScale );
		model.addAttribute("pageCnt",pageCnt );
		model.addAttribute("startNum",startNum );
		model.addAttribute("endNum",endNum );
		model.addAttribute("currentPage",bVO.getCurrentPage() );
		
		model.addAttribute("carList", es.subquery(bVO));
		
		return "mybatis/day0525/subquery";
	}//subquery
	
	@RequestMapping(value="/mybatis/day0525/union.do", method = GET)
	public String union(Model model) {
		
		model.addAttribute("empList", es.union());
		
		return "mybatis/day0525/union";
	}//like
}//class






