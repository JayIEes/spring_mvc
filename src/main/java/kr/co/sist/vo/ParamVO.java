package kr.co.sist.vo;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Web Parameter 값을 받기 위해 생성된 VO<br/>
 * HTML Form Control명과 VO의 instance 변수명이 반드시 같아야 한
 * @author user
 */
@Getter
@Setter
public class ParamVO {

	private String name;
	private int age;


	
}
