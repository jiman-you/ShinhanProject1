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
public class CategoryVO {
	 private int CATEGORY_ID;
	 private String CATEGORY_NAME;
}
