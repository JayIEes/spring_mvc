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
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("kr.co.sist.dao.exam3.greaterThan",sal);
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public List<ModelDomain> like(String option) throws PersistenceException{
		List<ModelDomain> list=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("kr.co.sist.dao.exam3.like",option);
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public int selectTotalCount(BoardVO bVO) {
		int totalCnt=0;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		//Mapper�� ParameterType�� �����Ƿ� �ι�° �Ű������� �������� �ʴ´�.
		totalCnt=ss.selectOne("kr.co.sist.dao.exam3.selectCarCnt",bVO);
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
				
		return totalCnt;
	}//selectTotalCount
	
	
	
	public List<ModelDomain> subquery(BoardVO bVO) throws PersistenceException{
		List<ModelDomain> list=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("kr.co.sist.dao.exam3.subquery",bVO);
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public List<EmpDomain> union() throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("kr.co.sist.dao.exam3.union");
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	
	
}
