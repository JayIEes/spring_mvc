package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DiDAO2 {

	public List<String> getList() throws SQLException{
		
		List<String> list=new ArrayList<String>();
		list.add("안녕~");
		list.add("오늘은");
		list.add("수요일");
		list.add("입니다!!");
		//데이터 베이스에서 조회된 결과라고 가정
		
		
		return list;
	}
	
}
