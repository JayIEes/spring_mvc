package kr.co.sist.dao.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis Framework을 생성하고 MyBatis Handler를 반환
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
			//1. 설정파일 연결
			Reader reader=null;
			
			try {
				//2.
				reader=Resources.getResourceAsReader("kr/co/sist/dao/mybatis/SqlMapConfig.xml"); //확장자를 넣었을 때 /를 이용하여 경로 설정
			
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
