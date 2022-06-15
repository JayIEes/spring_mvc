package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.DiDAO;

/**
 * DiDAO를 의존성 주입 받아 사용하는 클래스
 * @author user
 */
public class DiService {

	private DiDAO dao;
	
	
	
	public DiService(DiDAO dao) {
		this.dao=dao;
	}//DiService
	
	
	
	public List<String> searchData(){
		List<String> list=null;
		
		try {
			list=dao.getList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}//searchData
	
}
