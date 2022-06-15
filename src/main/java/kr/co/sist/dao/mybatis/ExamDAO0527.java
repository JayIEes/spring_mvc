package kr.co.sist.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.JoinDomain;
import kr.co.sist.vo.DynamicVO;
import kr.co.sist.vo.EmpVO;


@Component
public class ExamDAO0527 {
	
	
	public List<EmpDomain> dynamicChoose(DynamicVO dVO) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ¾ò±â
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//Äõ¸®¹® ¼öÇà
		list=ss.selectList("kr.co.sist.dao.exam5.choose",dVO);
		
		//Handler ´Ý±â
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public List<EmpDomain> dynamicTrim(DynamicVO dVO) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ¾ò±â
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//Äõ¸®¹® ¼öÇà
		list=ss.selectList("kr.co.sist.dao.exam5.trim",dVO);
		
		//Handler ´Ý±â
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	public int dynamicSet(EmpVO eVO) throws PersistenceException{
		int rowCnt=0;
		
		//Handler ¾ò±â
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//Äõ¸®¹® ¼öÇà
		rowCnt=ss.update("kr.co.sist.dao.exam5.set",eVO);
		if(rowCnt==1) {
			ss.commit();
		}
		//Handler ´Ý±â
		if(ss!=null) {ss.close();}
		
		return rowCnt;
	}
	
}//class
