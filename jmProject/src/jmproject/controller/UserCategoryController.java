package jmproject.controller;

import java.util.Scanner;

import jmproject.service.CategoryService;
import jmproject.service.User_tService;
import jmproject.view.CategoryView;

//유저 카테고리 조회
public class UserCategoryController {

	public UserCategoryController(String userId, String userPass) {
		while (true) {
			Scanner sc = new Scanner(System.in);

			System.out.println(userId + "회원 입니다.");

			CategoryService cService = new CategoryService();
			CategoryView.print(cService.selectAll());

			System.out.print("작업을 선택해주세요>>");
			String job = sc.next();

			switch (job) {
			case "1":// 옷
				UserProductController up1 = new UserProductController(1, userId, userPass);
				break;
			case "2":// 가전제품
				UserProductController up2 = new UserProductController(2, userId, userPass);
				break;
			case "3":// 식품
				UserProductController up3 = new UserProductController(3, userId, userPass);
				break;

			}
			if (job.equals("4")) {
				System.out.println("회원 화면으로 이동합니다");
				break;
			}
		}
	}
}
