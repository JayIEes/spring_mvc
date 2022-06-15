package kr.co.sist.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;


@Component
public class ExamDAO {
	
	/**
	 * 컬럼 하나에 행 하나 조회
	 * @param deptno 부서명을 조회할 부서 번호
	 * @return 조회된 부서명
	 * @throws PersistenceException
	 */
	public String scsr(int deptno) throws PersistenceException{
		String dname="";
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		dname=ss.selectOne("kr.co.sist.dao.scsr",deptno);
		
		
		return dname;
	}

}





