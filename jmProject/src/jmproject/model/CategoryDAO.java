package jmproject.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dbutil.JmOracleUtil;
import com.shinhan.dbutil.OracleUtil;

import jmproject.vo.CategoryVO;

public class CategoryDAO {
	Connection conn;//오라클과 연결
	Statement st;//통로
	PreparedStatement pst;//?지원
	ResultSet rs;
	int resultCount;
	CallableStatement cst;

	//카테고리 모두조회
	public List<CategoryVO> selectAll() {
		String sql = """
				select * 
				from category
				""";//sql문
		List<CategoryVO> catelist = new ArrayList<>();//카테고리VO를 리스트만들기
		conn = JmOracleUtil.getConnection();//db연결
		
		try {
			st = conn.createStatement();//db통로연결
			rs=st.executeQuery(sql);//sql결과를 rs에 저장	
		
			while(rs.next()) {
				CategoryVO cate = makeCategory(rs);
				catelist.add(cate);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JmOracleUtil.dbDisconnect(rs, st, conn);
		}
		
		
		
		return catelist;
		
		
	}

	private CategoryVO makeCategory(ResultSet rs) throws SQLException {
		CategoryVO cate = new CategoryVO();
		cate.setCATEGORY_ID(rs.getInt("CATEGORY_ID"));
		cate.setCATEGORY_NAME(rs.getString("CATEGORY_NAME"));
		
		return cate;
	}
}
