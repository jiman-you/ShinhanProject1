package jmproject.controller;

import java.util.Scanner;
import jmproject.model.ProductDAO;

//메인화면(로그인화면)
public class JmController {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
	    
		while(true){
			System.out.println("=============메인화면입니다===========");
			System.out.println("1.비회원 2.회원 3.회원가입 4.Admin 5.종료");
			System.out.println("==================================");
		
			System.out.print("작업을 선택해주세요>>");
			
			String job = sc.next();
			if(job.equals("5")) break;//5번이 들어오면 종료
			
			switch(job) {
			case "1"://비회원
				NotuserController nouser = new NotuserController();
				break;
			case "2"://회원
				UserController user = new UserController();
				break;
			case "3"://회원가입
				MemberController member = new MemberController();
				break;
			case "4"://어드민
				AdminController admin = new AdminController();
				break;
				
			}
		}
		System.out.println("수고하셧습니다.");
		
	}
}
