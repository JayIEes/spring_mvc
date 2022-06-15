package kr.co.sist.vo;

import org.springframework.web.bind.annotation.RequestParam;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class DynamicVO {
	private int empno,deptno;
	private String job;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(@RequestParam(defaultValue = "0") int empno) {
		this.empno = empno;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(@RequestParam(defaultValue = "0")int deptno) {
		this.deptno = deptno;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	
}

