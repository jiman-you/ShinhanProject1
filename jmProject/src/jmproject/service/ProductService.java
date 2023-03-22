package jmproject.service;

import java.util.List;

import jmproject.model.ProductDAO;
import jmproject.vo.CategoryVO;
import jmproject.vo.ProductVO;

public class ProductService {
	ProductDAO proDao = new ProductDAO();
	
	public List<ProductVO> select1() {//옷 조회
	
		return proDao.select1();
	}
	public List<ProductVO> select2() {//가전제품조회
		
		return proDao.select2();
	}
	public List<ProductVO> select3() {//식품조회
		
		return proDao.select3();
	}
	//특정 상품 조회
		public ProductVO selectByName(String proname) {
			return proDao.selectByName(proname);
		}
		//입고
	public String proUpdate(ProductVO pro) {
		int result = proDao.proUpdate(pro);
		return result>0?"update성공":"update실패";	
	
	}
}
