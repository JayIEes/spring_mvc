package kr.co.sist.service.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDAO0524;
import kr.co.sist.dao.mybatis.ExamDAO0525;
import kr.co.sist.dao.mybatis.ExamDAO0526;
import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.JoinDomain;
import kr.co.sist.domain.mybatis.ModelDomain;
import kr.co.sist.vo.BoardVO;

@Component
public class ExamService0526 {

	@Autowired(required = false)
	private ExamDAO0526 eDAO; //Service에서 DAO를 의존성 주입받는다.
	


	public List<String> searchCountry(){
		List<String> list=null;
		
		try {
			list=eDAO.selectCountry();
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}//union
	
	
	
	public List<JoinDomain> join(String country){
		List<JoinDomain> list=null;
		
		try {
			list=eDAO.join(country);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}//union
	
	
	public List<JoinDomain> subqueryJoin(String country){
		List<JoinDomain> list=null;
		
		try {
			list=eDAO.subqueryJoin(country);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}//union
	
	
	public List<EmpDomain> dynamicTable(String tableName){
		List<EmpDomain> list=null;
		
		try {
			list=eDAO.dynamicTable(tableName);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}//union
	
	
	
	public String[] jobList() {
		String[] job= {"SALESMAN","MANAGER","ANALYST","PRESIDENT","CLERK"};
		
		return job;
	}
	
	
	public List<EmpDomain> dynamicIf(String job){
		List<EmpDomain> list=null;
		
		try {
			list=eDAO.dynamicIf(job);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return list;
	}//union
	
	
}
