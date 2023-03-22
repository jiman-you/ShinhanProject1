package jmproject.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JavaBeans기술: VO의 변수 접근지정자는 private, setter/getter, 기본생성자
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BuyVO {// value object
	private int BUY_ID;//구매번호
	private int PRODUCT_ID;//상품번호
	private String PRODUCT_NAME;//상품이름
	private int PRODUCT_PRICE;//상품가격
	private String USER_ID;//유저아이디
	private int AREA_ID;//유저지역
	private int BUY_AMOUNT;//구매수량
	private int BUY_PRICE;//총구매가격
	private Date BUY_DATE;//구매일자
}
