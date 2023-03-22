package jmproject.service;

import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbutil.JmOracleUtil;

import jmproject.model.BuyDAO;
import jmproject.vo.BuyVO;

public class BuyService {
	BuyDAO buyDao = new BuyDAO();
	
	//구매
	public String insBuy(String userId,String productName,int amount) {
		int result = buyDao.insBuy(userId,productName,amount);
		String message;
		if(result==-1) {
			message = "구매를 실패하셧습니다.";
		}else {
			message = productName+"을 구매하셧습니다.";
		}
		return message;
	}
	//구매내역조회
		public List<BuyVO> serchBuy(String userId) {
			
			return buyDao.serchBuy(userId);
		}
}