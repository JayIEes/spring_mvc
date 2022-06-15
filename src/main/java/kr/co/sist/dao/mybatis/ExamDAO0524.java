package kr.co.sist.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.mybatis.EmpDomain;

@Component
public class ExamDAO0524 {
	
	public List<String> scmr(int deptno) throws PersistenceException{
		
		List<String> list=null;
		
		//MyBatis Handler���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("scmr",deptno);
		
		///MyBatis Handler�ݱ�
		if(ss!=null) {ss.close();}
		
		
		return list;
	}//scmr
	
	
	
	public EmpDomain mcsr(int empno) throws PersistenceException{
		EmpDomain ed=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		ed=ss.selectOne("mcsr",empno);
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return ed;
	}
	
	
	
	public List<EmpDomain> mcmr(int deptno) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("mcmr",deptno);
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	public List<EmpDomain> lessThan(int sal) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("lessThan",sal);
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	
	
}
