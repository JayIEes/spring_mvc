package kr.co.sist.service.mybatis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.mybatis.ExamDAO0530;
import kr.co.sist.dao.mybatis.ExamDAO0531;
import kr.co.sist.domain.mybatis.EmpDomain;
import kr.co.sist.domain.mybatis.TestProcedureDomain;
import kr.co.sist.vo.ForeachVO;
import kr.co.sist.vo.InsertVO;

@Component
public class ExamService0531 {

	@Autowired(required = false)
	private ExamDAO0531 eDAO; //Service���� DAO�� ������ ���Թ޴´�.
	

	public List<TestProcedureDomain> searchAllProcedure() {
		List<TestProcedureDomain> list=new ArrayList<TestProcedureDomain>();
		
		
		try {
			List<Map<String,Object>> searchList=null;
			searchList=eDAO.selectAllProc();
			
			//��ȸ����� Map�� ����Ǿ��ֱ� ������ Domain���� �����͸� �̵��ϴ� �۾� ����.
			TestProcedureDomain tpd=null;
			for(Map<String,Object> map:searchList) {
				tpd=new TestProcedureDomain();
				tpd.setNum(((BigDecimal)map.get("NUM")).intValue());
				tpd.setName((String) map.get("NAME"));
				tpd.setEmail((String) map.get("EMAIL"));
				tpd.setAge(((BigDecimal)map.get("AGE")).intValue());
				tpd.setInput_date((String) map.get("INPUT_DATE"));
				
				list.add(tpd);
			}
			
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}//
	
	
	
	public List<TestProcedureDomain> searchNumTestProcedure(int num) {
		List<TestProcedureDomain> list=new ArrayList<TestProcedureDomain>();
		
		
		try {
			List<Map<String,Object>> searchList=null;
			
			//�Էµ� ������ Map�� �����Ѵ�.
			Map<String,Object> Parammap =new HashMap<String, Object>();
			Parammap.put("num", num); //#{num,mode=IN
			
			//Map�� �Ҵ��Ͽ� �˻� ����
			searchList=eDAO.selectNumProc(Parammap);
			
			//��ȸ����� Map�� ����Ǿ��ֱ� ������ Domain���� �����͸� �̵��ϴ� �۾� ����.
			TestProcedureDomain tpd=null;
			for(Map<String,Object> map:searchList) {
				tpd=new TestProcedureDomain();
				tpd.setNum(((BigDecimal)map.get("NUM")).intValue());
				tpd.setName((String) map.get("NAME"));
				tpd.setEmail((String) map.get("EMAIL"));
				tpd.setAge(((BigDecimal)map.get("AGE")).intValue());
				tpd.setInput_date((String) map.get("INPUT_DATE"));
				
				list.add(tpd);
			}
			
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		
		return list;
	}//
	

	
}
