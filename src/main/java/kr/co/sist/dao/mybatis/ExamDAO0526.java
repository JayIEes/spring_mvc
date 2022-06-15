package kr.co.sist.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.JoinDomain;


@Component
public class ExamDAO0526 {
	
	
	
	public List<String> selectCountry() throws PersistenceException{
		List<String> list=null;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		list=ss.selectList("kr.co.sist.dao.exam4.selectCountry");
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	
	public List<JoinDomain> join(String country) throws PersistenceException{
		List<JoinDomain> list=null;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		list=ss.selectList("kr.co.sist.dao.exam4.join",country);
		
		//ParameterType을 넣지 않은 경우 발생하는 에러 : 부적합한 열 유형 : 1111
		//부적합한 열 유형 : 1111 은 mapper에 전달되는 값이 없다.
		//list=ss.selectList("kr.co.sist.dao.exam4.join");
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public List<JoinDomain> subqueryJoin(String country) throws PersistenceException{
		List<JoinDomain> list=null;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		list=ss.selectList("kr.co.sist.dao.exam4.subqueryJoin",country);
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public List<EmpDomain> dynamicTable(String tableName) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		list=ss.selectList("kr.co.sist.dao.exam4.dynamicTable",tableName);
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
		
		return list;
	}
	

	
	public List<EmpDomain> dynamicIf(String job) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//쿼리문 수행
		list=ss.selectList("kr.co.sist.dao.exam4.dynamicIf",job);
		
		//Handler 닫기
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	/*
	 * public static void main(String[] args) { ExamDAO0526 e=new ExamDAO0526();
	 * System.out.println(e.dynamicIf("MANAGER"));
	 * 
	 * }
	 */
	
	
	
}//class
