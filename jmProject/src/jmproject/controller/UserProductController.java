package jmproject.controller;

import java.util.Scanner;

import jmproject.service.ProductService;
import jmproject.view.CategoryView;
import jmproject.view.ProductView;

//유저 상품 조회
public class UserProductController {
	public UserProductController(int i,String userId,String userPass) {
		ProductService pService = new ProductService();
		Scanner sc = new Scanner(System.in);
		
		switch(i) {
		case 1:// 옷
			ProductView.print(pService.select1());
			break;
		case 2:// 가전제품
			ProductView.print(pService.select2());
			break;
		case 3:// 식품
			ProductView.print(pService.select3());
			break;
		}
		
		System.out.println("==================================");
		System.out.println("1.구매하기 2.카테고리");
		System.out.print("작업을 선택해주세요>>");
		int job = sc.nextInt();
	
		switch(job) {
		case 1://구매하기
			BuyController buy = new BuyController(userId,userPass);
			break;
		case 2:// 카테고리
			System.out.println("카테고리로 돌아갑니다.");
			break;
	
		}
	}
}
