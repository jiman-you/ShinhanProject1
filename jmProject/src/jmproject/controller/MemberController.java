package jmproject.controller;

import java.util.Scanner;

import jmproject.service.User_tService;
import jmproject.view.User_tView;
import jmproject.vo.User_tVO;

//회원가입 페이지
public class MemberController {
	public MemberController() {
		User_tService uService = new User_tService();
		Scanner sc = new Scanner(System.in);

		// 회원가입
		User_tVO user = makeUser(sc);
		User_tView.print(uService.UserInsert(user));
		
	}



	private User_tVO makeUser(Scanner sc) {
		System.out.println("1. 신규 유저의 아이디>>");
		String user_id = sc.next();
		System.out.println("2. 신규 유저의 비밀번호>>");
		String user_password = sc.next();
		System.out.println("3. 신규 유저의 이름>>");
		String user_name = sc.next();
		System.out.println("4. 신규 유저의 이메일>>");
		String user_email = sc.next();
		System.out.println("5. 신규 유저의 전화번호>>");
		String user_call = sc.next();
		System.out.println("6. 신규 유저의 사는 지역");
		System.out.print("301서울 302경기도 303강원도 304제주도>>");
		int area_id = sc.nextInt();

		//User_tVO타입 객체에 받아온 정보들을 삽입
		User_tVO user = new User_tVO();
		user.setUSER_ID(user_id);
		user.setUSER_PASSWORD(user_password);
		user.setUSER_NAME(user_name);
		user.setUSER_EMAIL(user_email);
		user.setUSER_CALL(user_call);
		user.setAREA_ID(area_id);

		return user;
	}
}
