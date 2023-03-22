package jmproject.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbutil.JmOracleUtil;

import jmproject.vo.BuyVO;
import jmproject.vo.ProductVO;
import jmproject.vo.User_tVO;

public class BuyDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int resultCount;
	CallableStatement cst;
	int count;


	

	//구매
	public int insBuy(String userId, String productName, int amount) {
		BuyVO buy = null;
		User_tVO user = null;
		ProductVO pro = null;
		//유저ID를 받아와 유저ID와 지역번호 얻어옴
		String sql1 = """
				select user_id,area_id
				from user_t where user_id=?
				""";
		//상품이름을 받아와 상품ID 상품이름 상품가격 얻어옴
		String sql2 = """
				select product_id,product_name,product_price
				from product where product_name=?
				""";
		//구매 테이블에 새로운 정보 추가
		String sql3 = """
				insert into buy values(
				buyseq.nextval,?,?,?,?,?,?,
				?,to_date(sysdate,'YYYY-MM-DD'))
				""";
		conn = JmOracleUtil.getConnection();

		try {
			// user의 정보 가져오기
			pst = conn.prepareStatement(sql1);
			pst.setString(1, userId);
			rs = pst.executeQuery();
			while (rs.next()) {
				user = makeUser(rs);
			}
			// 상품의 정보 가져오기
			pst = conn.prepareStatement(sql2);
			pst.setString(1, productName);
			rs = pst.executeQuery();
			while (rs.next()) {
				pro = makePro(rs);
			}
			// 상품구매
			//위 2가지 spq문에서 가져온 정보들과 유저가 직접 입력한 정보들 삽입
			pst = conn.prepareStatement(sql3);
			pst.setInt(1, pro.getPRODUCT_ID());
			pst.setString(2, pro.getPRODUCT_NAME());
			pst.setInt(3, pro.getPRODUCT_PRICE());
			pst.setString(4, user.getUSER_ID());
			pst.setInt(5, user.getAREA_ID());
			pst.setInt(6, amount);
			pst.setInt(7, amount * (pro.getPRODUCT_PRICE()));

			 pst.executeUpdate(); // DML 문장을 실행. 영향을 받은 건수가 리턴
		} catch (SQLException e) {
		
		
		}

		return resultCount;

	}
	//구매시 유저 정보 가져옴
	private ProductVO makePro(ResultSet rs) throws SQLException {
		ProductVO pro = new ProductVO();
		pro.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
		pro.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
		pro.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));

		return pro;
	}
	//구매시 상품정보 가져옴
	private User_tVO makeUser(ResultSet rs) throws SQLException {
		User_tVO user = new User_tVO();
		user.setUSER_ID(rs.getString("USER_ID"));
		user.setAREA_ID(rs.getInt("AREA_ID"));

		return user;
	}

	//구매내역조회
	public List<BuyVO> serchBuy(String userId) {
		//유저 아이디를 받아와 구매테이블과 유저테이블의 정보들을 받아옴
		String sql = """
				select user_id,product_name,product_price,buy_amount, buy_price,buy_date, user_t.area_id 
				from buy join user_t using(user_id)
				where user_id =?
				""";
		//정보들을 BuyVO타입의 buylist에 저장
		List<BuyVO> buylist = new ArrayList<>();
		conn = JmOracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			rs=pst.executeQuery();
			
			
			while(rs.next()) {
				BuyVO sbuy = makeBuy(rs);
				buylist.add(sbuy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			JmOracleUtil.dbDisconnect(rs, pst, conn);
		}
		return buylist;
		
		
	}
	private BuyVO makeBuy(ResultSet rs) throws SQLException {
		BuyVO buy = new BuyVO();
		
		buy.setUSER_ID(rs.getString("USER_ID"));
		buy.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
		buy.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));
		buy.setBUY_AMOUNT(rs.getInt("BUY_AMOUNT"));
		buy.setBUY_PRICE(rs.getInt("BUY_PRICE"));
		buy.setBUY_DATE(rs.getDate("BUY_DATE"));
		buy.setAREA_ID(rs.getInt("AREA_ID"));
		
		
		return buy;
	}
	
}
