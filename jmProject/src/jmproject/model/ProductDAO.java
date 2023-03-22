package jmproject.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbutil.JmOracleUtil;
import com.shinhan.dbutil.OracleUtil;

import jmproject.vo.CategoryVO;
import jmproject.vo.ProductVO;

public class ProductDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	int resultCount;
	CallableStatement cst;

	//카테고리로 모두조회 -> 카테고리가 많아지면 int를 받아와 해결할것
	public List<ProductVO> select1() {
		String sql = """
				select *
				from Product
				where category_id = 1
								""";

			List<ProductVO> prolist = new ArrayList<>();
			conn = JmOracleUtil.getConnection();
			
			try {
				st = conn.createStatement();
				rs=st.executeQuery(sql);
				
				while(rs.next()) {
					ProductVO emp = makePro(rs);
					prolist.add(emp);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return prolist;

	}
	public List<ProductVO> select2() {
		String sql = """
				select *
				from Product
				where category_id = 2
								""";

			List<ProductVO> prolist = new ArrayList<>();
			conn = JmOracleUtil.getConnection();
			
			try {
				st = conn.createStatement();
				rs=st.executeQuery(sql);
				
				while(rs.next()) {
					ProductVO emp = makePro(rs);
					prolist.add(emp);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return prolist;

	}
	public List<ProductVO> select3() {
		String sql = """
				select *
				from Product
				where category_id = 3
								""";

			List<ProductVO> prolist = new ArrayList<>();
			conn = JmOracleUtil.getConnection();
			
			try {
				st = conn.createStatement();
				rs=st.executeQuery(sql);
				
				while(rs.next()) {
					ProductVO emp = makePro(rs);
					prolist.add(emp);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return prolist;

	}

	
	//특정 상품 조회
		public ProductVO selectByName(String proname) {
			//상품 이름을 받아와 특정상품조회
			ProductVO pro = null;
			String sql = "select * from product"
					+ " where product_name="+"'"+proname+"'";	
			conn = JmOracleUtil.getConnection();//지난번에 미리 해놓음
			try {
				st = conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()) {
					 pro= makePro(rs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				OracleUtil.dbDisconnect(rs, st, conn);
			}
			return pro;
		}
		private ProductVO makePro(ResultSet rs2) throws SQLException {
			ProductVO pro = new ProductVO();
			pro.setPRODUCT_ID(rs.getInt("PRODUCT_ID"));
			pro.setPRODUCT_NAME(rs.getString("PRODUCT_NAME"));
			pro.setPRODUCT_PRICE(rs.getInt("PRODUCT_PRICE"));
			pro.setCARRY_DATE(rs.getDate("CARRY_DATE"));
			pro.setAMOUNT(rs.getInt("AMOUNT"));
			pro.setCATEGORY_ID(rs.getInt("CATEGORY_ID"));
			
			return pro;
		}
		// 입고
		//ProductVO객체를 받아와 상품 이름과 같은 물품들을 업데이트
			public int proUpdate(ProductVO pro) {
				String sql = """
					update product set product_price=?,
					 carry_date= to_date(sysdate,'YYYY-MM-DD'),
					 amount=?
					 where product_name = ?
						""";
				conn = JmOracleUtil.getConnection();
				try {
					pst = conn.prepareStatement(sql);
				
					pst.setInt(1, pro.getPRODUCT_PRICE());
//					pst.setDate(2, pro.getCARRY_DATE());
					pst.setInt(2, pro.getAMOUNT());
					pst.setString(3, pro.getPRODUCT_NAME());
					
					resultCount = pst.executeUpdate();//DML 문장을 실행. 영향을 받은 건수가 리턴
					//System.out.println("update결과");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					resultCount=-1;
					e.printStackTrace();
				}finally {
					
					JmOracleUtil.dbDisconnect(null, pst, conn);
				}
				System.out.println("update결과:"+resultCount);
				return resultCount;
			}

}
