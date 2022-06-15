package kr.co.sist.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InsertVO {
	private int num,age,row_cnt;
	private String name,email,errmsg,result_msg;
}
