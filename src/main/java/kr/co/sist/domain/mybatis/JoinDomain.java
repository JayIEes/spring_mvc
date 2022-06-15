package kr.co.sist.domain.mybatis;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JoinDomain {
	private String maker,model,car_option,car_img;
	private int car_year,price;

}
