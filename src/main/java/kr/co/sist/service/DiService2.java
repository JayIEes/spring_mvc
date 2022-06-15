package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.DiDAO;
import kr.co.sist.dao.DiDAO2;

/**
 * DiDAO2�� ������ ���� �޾� ����ϴ� Ŭ����
 * @author user
 */
@Component("ds2")
public class DiService2 {
	
	@Autowired(required = false)
	private DiDAO2 dao;
	
	
	
	
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
