package kr.co.sist.service.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDAO;

@Component
public class ExamService {

	@Autowired(required = false)
	private ExamDAO eDAO;
	
	
	public String scsr(int deptno) {
		String dname="";
		
		dname=eDAO.scsr(deptno);
		
		return dname;
	}
	
}
