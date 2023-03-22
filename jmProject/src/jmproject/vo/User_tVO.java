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
public class User_tVO {// value object
	private String USER_ID;//유저아이디
	private String USER_PASSWORD;//유저비밀번호
	private String USER_NAME;//유저이름
	private String USER_EMAIL;//유저이메일
	private Date USER_DATE;//유저생년월일
	private String USER_CALL;//유저핸드폰
	private int AREA_ID;//유저지역번호
}
