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
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("kr.co.sist.dao.exam4.selectCountry");
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	
	public List<JoinDomain> join(String country) throws PersistenceException{
		List<JoinDomain> list=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("kr.co.sist.dao.exam4.join",country);
		
		//ParameterType�� ���� ���� ��� �߻��ϴ� ���� : �������� �� ���� : 1111
		//�������� �� ���� : 1111 �� mapper�� ���޵Ǵ� ���� ����.
		//list=ss.selectList("kr.co.sist.dao.exam4.join");
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public List<JoinDomain> subqueryJoin(String country) throws PersistenceException{
		List<JoinDomain> list=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("kr.co.sist.dao.exam4.subqueryJoin",country);
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	public List<EmpDomain> dynamicTable(String tableName) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("kr.co.sist.dao.exam4.dynamicTable",tableName);
		
		//Handler �ݱ�
		if(ss!=null) {ss.close();}
		
		return list;
	}
	

	
	public List<EmpDomain> dynamicIf(String job) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ���
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//������ ����
		list=ss.selectList("kr.co.sist.dao.exam4.dynamicIf",job);
		
		//Handler �ݱ�
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
