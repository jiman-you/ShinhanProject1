package jmproject.view;

import java.util.List;

import jmproject.vo.BuyVO;
import jmproject.vo.CategoryVO;

public class CategoryView {
	static int count=1;
	//비회원 카테고리 조회
	public static void printno(List<CategoryVO> calist) {
		System.out.println("");
		System.out.println("비회원 입니다.");
		System.out.println("=============카테고리==============");
		
		for(CategoryVO emp : calist) {
			String ca = emp.getCATEGORY_NAME();
			System.out.print(count+"."+ca+" ");//카테고리 수 만큼 번호매김
			count++;
		}
		
		System.out.println(count+".메인 화면");
		System.out.println("==================================");
		count=1;
	}
	
	//회원 카테고리 조회
	public static void print(List<CategoryVO> calist) {
		System.out.println("");
		System.out.println("===============카테고리==============");
		
		for(CategoryVO emp : calist) {
			String ca = emp.getCATEGORY_NAME();
			System.out.print(count+"."+ca+" ");
			count++;
		}
	
		System.out.println(count+".유저페이지");
		System.out.println("==================================");
		count=1;
	}
	
	
}
