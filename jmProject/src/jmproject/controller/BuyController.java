package jmproject.controller;

import java.util.Scanner;

import jmproject.service.BuyService;
import jmproject.view.BuyView;
import jmproject.vo.BuyVO;


//상품 구매
public class BuyController {
	static public String productName;
	static public int amount;

	// 구매 페이지
	public BuyController(String userId, String userPass) {

		BuyService bService = new BuyService();
		Scanner sc = new Scanner(System.in);

		// 상품이름 입력해서 정보 얻어온 후 구매
		System.out.print("구매할 상품>>");
		productName = sc.next();
		System.out.print("구매할 개수>>");
		amount = sc.nextInt();
		sc.nextLine();
		// 상품id,상품이름,상품가격,유저아이디,유저지역 구한 것과 수량을 포함해 buy테이블 추가
		BuyView.print(bService.insBuy(userId,productName, amount));
		
//		while (true) {
//			System.out.println("");
//			System.out.println("==================================");
//			System.out.println("1.카테고리 2.마이 페이지 3.로그인 화면 ");
//			System.out.println("==================================");
//
//			System.out.print("작업을 선택해주세요>>");
//
//			String job = sc.next();
//			if (job.equals("3"))
//				break;// 5번이 들어오면 종료
//
//			switch (job) {
//			case "1":// 카테고리
//				UserCategoryController uc = new UserCategoryController(userId, userPass);
//				break;
//			case "2":// 마이 페이지
//				UserController user = new UserController();
//				break;
//			}

//		}
	}
}
