package kr.co.sist.service.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDAO0524;
import kr.co.sist.dao.mybatis.ExamDAO0525;
import kr.co.sist.dao.mybatis.ExamDAO0526;
import kr.co.sist.dao.mybatis.ExamDAO0527;
import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.JoinDomain;
import kr.co.sist.domain.mybatis.ModelDomain;
import kr.co.sist.vo.BoardVO;
import kr.co.sist.vo.DynamicVO;
import kr.co.sist.vo.EmpVO;

@Component
public class ExamService0527 {

	@Autowired(required = false)
	private ExamDAO0527 eDAO; //Service에서 DAO를 의존성 주입받는다.
	
	
	public List<EmpDomain> dynamicChoose(DynamicVO dVO){
		List<EmpDomain> list=null;
		
		try {
			list=eDAO.dynamicChoose(dVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//dynamicChoose
		
		return list;
	}//union
	
	
	public List<EmpDomain> dynamicTrim(DynamicVO dVO){
		List<EmpDomain> list=null;
		
		try {
			list=eDAO.dynamicTrim(dVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//dynamicChoose
		
		return list;
	}//union
	
	
	public boolean dynamicSet(EmpVO eVO){
		boolean flag=false;
		try {
			int cnt=eDAO.dynamicSet(eVO);
			flag=cnt==1;
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}//dynamicChoose
		
		return flag;
	}//union
	
	
}
