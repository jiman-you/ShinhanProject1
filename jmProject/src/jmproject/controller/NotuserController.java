package jmproject.controller;

import java.util.Scanner;

import jmproject.service.CategoryService;
import jmproject.view.CategoryView;

//비회원 페이지
public class NotuserController {
	public NotuserController() {
		while(true) {
		CategoryService cService = new CategoryService();
		CategoryView.printno(cService.selectAll());
		
		System.out.print("작업을 선택해주세요>>");

		Scanner sc = new Scanner(System.in);
		String job = sc.next();
		
		switch (job) {
		case "1":// 옷
			NoProductController no = new NoProductController(1);
			break;
		case "2":// 가전제품
			NoProductController no2 = new NoProductController(2);
			break;
		case "3":// 식품
			NoProductController no3 = new NoProductController(3);
			break;
		
		}
		if(job.equals("4")){// 메인화면
			System.out.println("메인 화면으로 이동합니다.");
			break;
		}
		}
	}
}
