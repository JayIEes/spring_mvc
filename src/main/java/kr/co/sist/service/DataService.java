package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� ���� (business logic)�� ó���ϴ� �ڵ�. 
 * @author user
 */
public class DataService {
	public List<String> searchData(){
		List<String> list=new ArrayList<String>();
		list.add("�ڹ�");
		list.add("JSP");
		list.add("HTML");
		list.add("CSS");
		
		
		return list;
	}
}