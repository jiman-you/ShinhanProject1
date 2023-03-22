package jmproject.view;

import java.util.List;


import jmproject.vo.BuyVO;
import jmproject.vo.ProductVO;
import jmproject.vo.User_tVO;

public class BuyView {

	public static void print(List<BuyVO> buylist) {
		System.out.println("========구매내역조회=========");
		if(buylist==null) {
			print("구매내역이 존재하지 않습니다.");
		}else {
			for(BuyVO buy:buylist) {
				System.out.println("회원이름>>"+buy.getUSER_ID());
				System.out.println("구매 상품>>"+buy.getPRODUCT_NAME());
				System.out.println("상품 단가>>"+buy.getPRODUCT_PRICE()+"원");
				System.out.println("구매 개수>>"+buy.getBUY_AMOUNT()+"개");
				System.out.println("총 가격>>"+buy.getBUY_PRICE()+"원");
				System.out.println("구매일>>"+buy.getBUY_DATE());
				
				if(buy.getAREA_ID() == 301) 
					System.out.println("배송지>> 서울");
				else if (buy.getAREA_ID() == 302)
					System.out.println("배송지>> 경기도");
				else if (buy.getAREA_ID()==303)
					System.out.println("배송지>> 강원도");
				else if(buy.getAREA_ID() == 304)
					System.out.println("배송지>> 제주도");
				
		}
			
		}
	}
	public static void print(String message) {
		System.out.println("[알림]"+message);
	}
	
}
