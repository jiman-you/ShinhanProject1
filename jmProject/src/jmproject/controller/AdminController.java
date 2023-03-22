package jmproject.controller;

import java.sql.Date;
import java.util.Scanner;

import jmproject.service.ProductService;
import jmproject.service.User_tService;
import jmproject.view.ProductView;
import jmproject.view.User_tView;
import jmproject.vo.ProductVO;

//관리자 페이지
public class AdminController {
	static public String userId;
	static public String userPass;
	public AdminController() {
		while(true) {
		ProductService pService = new ProductService();
		User_tService uService = new User_tService();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("");
		System.out.println("=============관리자 로그인===========");
		System.out.print("관리자 아이디를 입력해주세요>>");
		userId = sc.next();
		System.out.print("관리자 비밀번호를 입력해주세요>>");
		userPass= sc.next();
		
		int ok = User_tView.print2(uService.AdminLogin(userId, userPass));
		
		//관리자가 아니면 메인화면
		if(ok == 0) {
			break;
		}
		
		System.out.println("=============입고===========");
		
		System.out.println("입고할 제품 명>>");
		String proname = sc.next();
		ProductView.printAdmin(pService.selectByName(proname));
		System.out.print("\n1 입고 가격>>");
		int pro_price= sc.nextInt();
//		System.out.print("\n2 입고일yyyy/mm/dd>>");
//		String pdate= sc.next();
//		Date prodate = DateUtil.convertToDate(pdate);
		System.out.print("\n2 입고량>>");
		int amount = sc.nextInt();
		
		//제품명으로 검색해 해당 상품에 맞는 정보들을 가져와 ProductVO타입 객체에 삽입
		ProductVO pro = new ProductVO();
		pro.setCATEGORY_ID(pService.selectByName(proname).getCATEGORY_ID());
		pro.setPRODUCT_ID(pService.selectByName(proname).getPRODUCT_ID());
		pro.setPRODUCT_NAME(pService.selectByName(proname).getPRODUCT_NAME());
		pro.setCARRY_DATE(pService.selectByName(proname).getCARRY_DATE());
		
		//받은 문자를 ProductVO타입의 객체에 삽입
		pro.setPRODUCT_PRICE(pro_price);
		int num = amount+pService.selectByName(proname).getAMOUNT();
		pro.setAMOUNT(num);
		
		
		ProductView.print(pService.proUpdate(pro));//수정된 정보 업데이트
		ProductView.printAdmin(pService.selectByName(proname));//수정된 정보 출력
		
		break;
		}
		
	}

//	private ProductVO makepro(Scanner sc, String proname) {
//		System.out.print("\n1 입고 가격>>");
//		int pro_price= sc.nextInt();
//		System.out.print("\n2 입고일yyyy/mm/dd>>");
//		String pdate= sc.next();
//		Date prodate = DateUtil.convertToDate(pdate);
//		System.out.print("\n3 입고량>>");
//		int amount = sc.nextInt();
//		
//		ProductVO pro = new ProductVO();//받은 문자를 EmpVO타입의 객체에 삽입
//		pro.setPRODUCT_PRICE(pro_price);
//		pro.setCARRY_DATE(prodate);
//		pro.setAMOUNT(amount);
//		return pro;
//	}
}
