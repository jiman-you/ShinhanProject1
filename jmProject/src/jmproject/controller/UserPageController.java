package jmproject.controller;

import java.sql.Date;
import java.util.Scanner;

import jmproject.service.BuyService;
import jmproject.service.User_tService;
import jmproject.view.BuyView;
import jmproject.view.ProductView;
import jmproject.view.User_tView;
import jmproject.vo.User_tVO;

//마이페이지
public class UserPageController {

	public UserPageController(String userId, String userPass) {

		User_tService uService = new User_tService();
		BuyService buy = new BuyService();
		Scanner sc = new Scanner(System.in);
	
		System.out.println("");
		System.out.println("==============마이 페이지=============");
		System.out.println("1.개인정보수정 2.구매내역 3.유저 페이지 ");

		String job = sc.next();

		switch (job) {//수가 적어 한곳에 해결햇지만 많아지면 클래스 나눌것.
		case "1":// 개인정보 수정
			User_tVO user = new User_tVO();
			
			System.out.println("");
			System.out.println("=============개인정보수정===========");
			user.setUSER_ID(userId);
			System.out.print("1 비밀번호 수정>>");
			String pass = sc.next();
			user.setUSER_PASSWORD(pass);
			System.out.print("\n2 이름 수정>>");
			String name = sc.next();
			user.setUSER_NAME(name);
			System.out.print("\n3 이메일 수정>>");
			String email = sc.next();
			user.setUSER_EMAIL(email);
			System.out.print("\n4 전화번호 수정>>");
			String call = sc.next();
			user.setUSER_CALL(call);
			System.out.print("\n5 지역 수정>>");
			int area = sc.nextInt();
			user.setAREA_ID(area);
			
			User_tView.print(uService.userUpdate(user));
			
			break;
		case "2":// 구매내역
			BuyService bService = new BuyService();
			BuyView.print(bService.serchBuy( userId));
			
			break;
		}

	}
}
