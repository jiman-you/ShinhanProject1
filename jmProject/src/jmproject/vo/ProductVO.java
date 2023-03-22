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
public class ProductVO {// value object
	private int PRODUCT_ID;//상품번호
	private String PRODUCT_NAME;//상품이름
	private int  PRODUCT_PRICE;//상품가격
	private Date CARRY_DATE;//입고일
	private int  AMOUNT;//상품잔여수량
	private int  CATEGORY_ID;//카테고리번호

}
