package kr.co.sist.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.vo.InsertVO;


@Component
public class ExamDAO0530 {
	
	
	public List<EmpDomain> selectForeach(Map<String, Object> map) throws PersistenceException{
		List<EmpDomain> list=null;
		
		//Handler ¾ò±â
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		//Äõ¸®¹® ¼öÇà
		list=ss.selectList("kr.co.sist.dao.exam6.dynamicForeach",map);
		
		//Handler ´Ý±â
		if(ss!=null) {ss.close();}
		
		return list;
	}
	
	
	public void insertProcedure(InsertVO iVO) throws PersistenceException{
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		ss.selectOne("kr.co.sist.dao.exam6.insertProc",iVO);
		
		if(ss!=null) {ss.close();}
		
	}
	
	
	public void updateProcedure(InsertVO iVO) throws PersistenceException{
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		ss.selectOne("kr.co.sist.dao.exam6.updateProc",iVO);
		
		if(ss!=null) {ss.close();}
		
	}
	
	
	public void deleteProcedure(InsertVO iVO) throws PersistenceException{
		SqlSession ss=MyBatisFramework.getInstance().getMyBatisHandler();
		
		ss.selectOne("kr.co.sist.dao.exam6.deleteProc",iVO);
		
		if(ss!=null) {ss.close();}
		
	}
	
	
	
}//class
