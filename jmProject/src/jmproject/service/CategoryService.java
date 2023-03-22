package jmproject.service;

import java.util.List;

import jmproject.model.CategoryDAO;
import jmproject.vo.CategoryVO;

public class CategoryService {
	CategoryDAO cateDao = new CategoryDAO();
	
	//카테고리
	public List<CategoryVO> selectAll() {
	
		return cateDao.selectAll();
	}
}
