package kr.co.sist.service.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDAO0524;
import kr.co.sist.dao.mybatis.ExamDAO0525;
import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.ModelDomain;
import kr.co.sist.vo.BoardVO;

@Component
public class ExamService0525 {

	@Autowired(required = false)
	private ExamDAO0525 eDAO; //Service에서 DAO를 의존성 주입받는다.
	

	public List<EmpDomain> greaterThan(int sal){
		List<EmpDomain> list=null;
		
		try {
			list=eDAO.greaterThan(sal);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	public List<ModelDomain> like(String option){
		List<ModelDomain> list=null;
		
		try {
			list=eDAO.like(option);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////
	/**
	 * 전체 레코드의 수
	 * @return
	 */
	public int searchTotalCount(BoardVO bVO) {
		int cnt=0;
		
		try{
			setKeyword(bVO);
			cnt=eDAO.selectTotalCount(bVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return cnt;
	}
	
	
	
	
	/**
	 * 한 화면에 보여줄 게시글의 수
	 * @return
	 */
	public int pageScale() {
		int pageScale=10;
		
		return pageScale;
	}
	
	
	
	/**
	 * 모든 게시물을 보여주기 위한 페이지의 수
	 * @param totalCnt
	 * @param pageScale
	 * @return
	 */
	public int pageCnt(int totalCnt, int pageScale) {
		 int pageCnt=0;
		 
		 pageCnt=(int)Math.ceil((double)totalCnt/(double)pageScale);
		 
		 
		 return pageCnt;
	}//pageCnt
	
	
	
	/**
	 * 시작번호 구하기
	 * @param currentPage - 현재 페이지 번호
	 * @param pageScale - 한 화면에 보여줄 페이지 수
	 * @return
	 */
	public int startNum(int currentPage, int pageScale) {
		
		int startNum=1;
		
		startNum=currentPage*pageScale-pageScale+1;
		
		
		return startNum;
		
	}//startNum
	
	
	
	/**
	 * 끝번호 구하기
	 * @param startNum
	 * @param pageScale
	 * @return
	 */
	public int endNum(int startNum, int pageScale) {
		int endNum=0;
		
		endNum=startNum+pageScale-1;
		
		return endNum;
	}
	
	
	public void setKeyword(BoardVO bVO) {
		if(!"".equals(bVO.getKeyword())) {
			String field="car_option";
			if("1".equals(bVO.getField())) {
				field="model";
			}
			bVO.setField(field);
		}//end if
	}
	
	
	public List<ModelDomain> subquery(BoardVO bVO){
		List<ModelDomain> list=null;
		
		try {
			//검색 field와 field에 대한 설정
			if(!"".equals(bVO.getKeyword())) {
				String field="car_option";
				if("1".equals(bVO.getField())||"model".equals(bVO.getField())) {
					field="model";
				}
				bVO.setField(field);
			}//end if
			
			list=eDAO.subquery(bVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public List<EmpDomain> union(){
		List<EmpDomain> list=null;
		
		try {
			list=eDAO.union();
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}//union
	
	
}
