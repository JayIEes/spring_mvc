package kr.co.sist.service.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDAO0524;
import kr.co.sist.domain.mybatis.EmpDomain;

@Component
public class ExamService0524 {

	@Autowired(required = false)
	private ExamDAO0524 eDAO; //Service에서 DAO를 의존성 주입받는다.
	
	public List<String> scmr(int deptno){
		List<String> list=null;
		
		try {
			list=eDAO.scmr(deptno);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		 
		 
		return list;
	}
	
	
	public EmpDomain mcsr(int empno) {
		EmpDomain ed = null;
		
		try {
			ed=eDAO.mcsr(empno);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return ed;
	}//mcsr
	
	
	
	public List<EmpDomain> mcmr(int deptno){
		List<EmpDomain> list=null;
		
		try {
			list=eDAO.mcmr(deptno);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}
	
	
	
	public List<EmpDomain> lessThan(int sal){
		List<EmpDomain> list=null;
		
		try {
			list=eDAO.lessThan(sal);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}
	
	
}
