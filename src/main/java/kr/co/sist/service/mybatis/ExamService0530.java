package kr.co.sist.service.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDAO0530;
import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.vo.ForeachVO;
import kr.co.sist.vo.InsertVO;

@Component
public class ExamService0530 {

	@Autowired(required = false)
	private ExamDAO0530 eDAO; //Service���� DAO�� ������ ���Թ޴´�.
	
	
	public List<EmpDomain> searchDynamicForeach(ForeachVO fVO){
		List<EmpDomain> list=null;
		
		//MyBatis���� ����ϱ� ���� Map�� �Է°��� �ִ´�.
		Map<String, Object> map=new HashMap<String, Object>();
		
		List<String> listJob=new ArrayList<String>();
		
		if(fVO.getJob()!=null) {
			for(String job:fVO.getJob()) {
				listJob.add(job);
			}//end for
		}
		
		//map.put("MyBatis���� ����� �̸�",��);
		map.put("deptno", fVO.getDeptno());
		map.put("listJob",listJob);
		map.put("arrJob",fVO.getJob());
		
		
		try {
			list=eDAO.selectForeach(map);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}//searchDynamicForeach
	
	
	public void addProcedure(InsertVO iVO) {
		
		try {
			eDAO.insertProcedure(iVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
	}
	
	
	
	public void modifyProcedure(InsertVO iVO) {
		
		try {
			eDAO.updateProcedure(iVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
	}
	
	
	public void removeProcedure(InsertVO iVO) {
		
		try {
			eDAO.deleteProcedure(iVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
	}
	
	
}
