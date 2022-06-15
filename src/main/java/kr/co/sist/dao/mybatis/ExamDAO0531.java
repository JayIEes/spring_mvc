package kr.co.sist.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.TestProcedureDomain;
import kr.co.sist.vo.InsertVO;


@Component
public class ExamDAO0531 {
	
	
	public List<Map<String, Object>> selectAllProc() throws PersistenceException{
		 List<Map<String, Object>> list=null;
		
		//Map 선언 : Procedure가 처리한 결과를 저장할 map
		Map<String, Object> map=new HashMap<String, Object>();
		
		//Handler 얻기
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		ss.selectOne("kr.co.sist.dao.exam7.selectAllTestProcedure",map);
		
		list= (List<Map<String, Object>>) map.get("allTestProc"); //#{allTestProc,mode=OUT ~}
		
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	/**
	 * 사용자가 입력한 번호가 map에 할당된다.
	 * @param map
	 * @return
	 * @throws PersistenceException
	 */
	public List<Map<String, Object>> selectNumProc(Map<String,Object> map) throws PersistenceException{
		
		List<Map<String, Object>> list=null;
		
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		ss.selectOne("selectNumTestProcedure",map);
		System.out.println("================="+map);
		list= (List<Map<String, Object>>) map.get("numTestProc"); //#{numTestProc,mode= ~}
		
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	
	
}//class
