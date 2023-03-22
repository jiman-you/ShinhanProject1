package jmproject.controller;

import jmproject.service.ProductService;
import jmproject.view.CategoryView;
import jmproject.view.ProductView;

//상품조회 페이지
public class NoProductController {
	public NoProductController(int i) {
		ProductService pService = new ProductService();
		switch(i) {//각 번호에 맞는 숫자를 받아서 DAO실행 (카테고리가 더 많아지면 하나로 뭉쳐서 int타입으로 받아서 해결할것)
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
	}
}
