package kr.co.sist.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.ModelDomain;
import kr.co.sist.vo.BoardVO;

@Component
public class ExamDAO0525 {
	
	
	public List<EmpDomain> greaterThan(int sal) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		list=ss.selectList("kr.co.sist.dao.exam3.greaterThan",sal);
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public List<ModelDomain> like(String option) throws PersistenceException{
		List<ModelDomain> list=null;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		list=ss.selectList("kr.co.sist.dao.exam3.like",option);
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public int selectTotalCount(BoardVO bVO) {
		int totalCnt=0;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		//Mapper에 ParameterType이 없으므로 두번째 매개변수가 존재하지 않는다.
		totalCnt=ss.selectOne("kr.co.sist.dao.exam3.selectCarCnt",bVO);
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
				
		return totalCnt;
	}//selectTotalCount
	
	
	
	public List<ModelDomain> subquery(BoardVO bVO) throws PersistenceException{
		List<ModelDomain> list=null;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		list=ss.selectList("kr.co.sist.dao.exam3.subquery",bVO);
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public List<EmpDomain> union() throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		list=ss.selectList("kr.co.sist.dao.exam3.union");
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	
	
}
