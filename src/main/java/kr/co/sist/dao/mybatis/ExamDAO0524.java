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
		
		//MyBatis Handler¾ò±â
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//Äõ¸®¹® ½ÇÇà
		list=ss.selectList("scmr",deptno);
		
		///MyBatis Handler´Ý±â
		if(ss!=null) {ss.close();}
		
		
		return list;
	}//scmr
	
	
	
	public EmpDomain mcsr(int empno) throws PersistenceException{
		EmpDomain ed=null;
		
		//Handler ¾ò±â
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//Äõ¸®¹® ¼öÇà
		ed=ss.selectOne("mcsr",empno);
		
		//Handler ´Ý±â
		if(ss!=null) {ss.close();}
		
		return ed;
	}
	
	
	
	public List<EmpDomain> mcmr(int deptno) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ¾ò±â
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//Äõ¸®¹® ¼öÇà
		list=ss.selectList("mcmr",deptno);
		
		//Handler ´Ý±â
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	public List<EmpDomain> lessThan(int sal) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ¾ò±â
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//Äõ¸®¹® ¼öÇà
		list=ss.selectList("lessThan",sal);
		
		//Handler ´Ý±â
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	
	
}
