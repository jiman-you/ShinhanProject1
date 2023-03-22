package jmproject.view;

import java.util.List;


import jmproject.vo.BuyVO;
import jmproject.vo.ProductVO;
import jmproject.vo.User_tVO;

public class User_tView {

	
	
	//유저 로그인
	public static int print(User_tVO user) {
		int i=0;
		if(user==null) {
			print("유저가 존재하지 않습니다.");
		}else {
			System.out.println(user.getUSER_NAME()+"님 환영합니다.");
			i=1;
		}
		return i;
	}
	//관리자 로그인
	public static int print2(User_tVO admin) {
		int i=0;
		if(admin==null) {
			print("관리자가 아닙니다.");
		}else {
			System.out.println("관리자님 환영합니다.");
			i=1;
		}
		return i;
	}

	public static void print(String message) {
		System.out.println("[알림]"+message);
	}
	
}
