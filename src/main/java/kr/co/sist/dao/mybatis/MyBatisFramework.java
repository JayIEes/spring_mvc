package kr.co.sist.dao.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis Framework�� �����ϰ� MyBatis Handler�� ��ȯ
 * @author user
 *
 */
public class MyBatisFramework {

	private static MyBatisFramework mbf;
	private static SqlSessionFactory ssf;
	
	
	
	private MyBatisFramework() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}
	
	
	
	public static MyBatisFramework getInstance() {
		if(mbf==null) {
			mbf=new MyBatisFramework();
		}
		
		return mbf;
	}
	
	
	
	private SqlSessionFactory getSqlSessionFactory() throws IOException{
		
		if(ssf==null) {
			//1. �������� ����
			Reader reader=null;
			
			try {
				//2.
				reader=Resources.getResourceAsReader("kr/co/sist/dao/mybatis/SqlMapConfig.xml"); //Ȯ���ڸ� �־��� �� /�� �̿��Ͽ� ��� ����
			
				//3.
				ssf=new SqlSessionFactoryBuilder().build(reader);
				
			}finally {
				if(reader!=null) {reader.close();}//end if
			}//end finally
			
		}//end if
		
		return ssf;
	}//getSqlSessionFactory
	
	
	
	public SqlSession getMyBatisHandler() {
		
		SqlSession ss=null;
		
		try {
			ss=getSqlSessionFactory().openSession();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return ss;
	}
	
	
	public static void main(String[] args) {
		
		MyBatisFramework mbf=getInstance(); 
		SqlSession ss=mbf.getMyBatisHandler();
		System.out.println(ss);
	}
	
	
}//class
