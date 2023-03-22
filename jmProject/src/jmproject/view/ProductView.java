package jmproject.view;

import java.util.List;

import jmproject.vo.BuyVO;
import jmproject.vo.CategoryVO;
import jmproject.vo.ProductVO;
import jmproject.vo.User_tVO;

public class ProductView {

	//회원 상품조회
	public static void print(List<ProductVO> prolist) {
		int i=1;
		System.out.println("===============상품==============");
		for (ProductVO pro : prolist) {
		
			System.out.print(i+".상품이름>>"+pro.getPRODUCT_NAME());
			System.out.print(" |가격>>"+pro.getPRODUCT_PRICE());
			System.out.print(" |입고일>>"+pro.getCARRY_DATE());
			System.out.println(" |재고량>>"+pro.getAMOUNT());
			
			i++;
		}

		System.out.println("==================================");

	}
	
	//관리자 상품조회
	public static void printAdmin(ProductVO productVO) {
		
		System.out.println("===============상품==============");
		if(productVO==null) {
			print("상품이 존재하지 않습니다.");
		}else {
			System.out.println(productVO);
		}
		}

		

	public static void print(String message) {
		System.out.println("[알림]" + message);
	}

}
