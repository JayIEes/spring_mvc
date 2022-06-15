package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.DiDAO;

/**
 * DiDAO�� ������ ���� �޾� ����ϴ� Ŭ����
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
