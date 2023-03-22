package jmproject.controller;

import java.util.Scanner;

import jmproject.service.User_tService;
import jmproject.view.User_tView;

//회원 페이지
public class UserController {
	//회원 페이지를 수행하며 전달해줄 정보들
	static public String userId;
	static public String userPass;

	public UserController() {

		User_tService uService = new User_tService();
		Scanner sc = new Scanner(System.in);

		System.out.print("아이디를 입력해주세요>>");
		userId = sc.next();
		System.out.print("비밀번호를 입력해주세요>>");
		userPass = sc.next();

		while (true) { // 로그인에 실패하면 초기 화면에 돌아가도록 while문 사용
			int ok = User_tView.print(uService.UserLogin(userId, userPass));

			if (ok == 0) {
				System.out.println("로그인에 실패하였습니다.");
				break;
			}
			System.out.println("");
			System.out.println("==============유저 페이지=============");
			System.out.println("1.카테고리 2.마이 페이지 3.메인 화면 ");
			System.out.println("==================================");

			System.out.print("작업을 선택해주세요>>");

			String job = sc.next();
			if (job.equals("3"))
				break;// 3번이 들어오면 종료

			switch (job) {
			case "1":// 카테고리
				UserCategoryController uc = new UserCategoryController(userId, userPass);
				break;
			case "2":// 마이 페이지
				UserPageController user = new UserPageController(userId, userPass);
				break;
			}

		}

	}
}