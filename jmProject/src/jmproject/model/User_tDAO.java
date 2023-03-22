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
import jmproject.vo.User_tVO;

public class User_tDAO {
	Connection conn;// 오라클과 연결
	Statement st;// 통로
	PreparedStatement pst;// ?지원
	ResultSet rs;
	int resultCount;// insert,update,delete건수
	CallableStatement cst;

	// 신규 회원 등록
	public int UserInsert(User_tVO user) {
		// 모든 변수업데이트
		
		String sql = """
				insert into user_t
				values(?,?,?,?,to_date(sysdate,'YYYY-MM-DD'),?,?)""";
		conn = JmOracleUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUSER_ID());
			pst.setString(2, user.getUSER_PASSWORD());
			pst.setString(3, user.getUSER_NAME());
			pst.setString(4, user.getUSER_EMAIL());
			pst.setString(5, user.getUSER_CALL());
			pst.setInt(6, user.getAREA_ID());
			
			resultCount = pst.executeUpdate();// DML 문장을 실행.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			resultCount = -1;
			e.printStackTrace();
		} finally {

			JmOracleUtil.dbDisconnect(null, pst, conn);
		}
		return resultCount;
	}

	// 관리자 로그인
	public User_tVO AdminLogin(String adId, String adPass) {
		//유저 아이디와 비밀번호를 받아와 모두조회
		String sql = "select * from user_t " 
				+ "where user_id = ? " 
				+ "and user_password = ?";

		conn = JmOracleUtil.getConnection();
		User_tVO user = null;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, adId);
			pst.setString(2, adPass);
			rs = pst.executeQuery();

			while (rs.next()) {
				user = makeAdmin(rs,adId,adPass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JmOracleUtil.dbDisconnect(rs, pst, conn);
		}
		return user;
	}

	private User_tVO makeAdmin(ResultSet rs,String adId,String adPass) throws SQLException {
		//받아오 아이디와 비밀번호가 관리자와 일치하면 정보입력
		User_tVO user = new User_tVO();
		if(adId.equals("admin")&&
			adPass.equals("adminpass")	) {
		user.setUSER_ID(rs.getString("USER_ID"));
		user.setUSER_PASSWORD(rs.getString("USER_PASSWORD"));
		user.setUSER_NAME(rs.getString("USER_NAME"));
		user.setUSER_EMAIL(rs.getString("USER_EMAIL"));
		user.setUSER_DATE(rs.getDate("USER_DATE"));
		user.setUSER_CALL(rs.getString("USER_CALL"));
		user.setAREA_ID(rs.getInt("AREA_ID"));
		}else return null;

		return user;
	}

	// 로그인
	public User_tVO UserLogin(String userId, String userPass) {
		//유저 아이디와 비밀번호를 받아와 조회
		String sql = "select * from user_t " + "where user_id = ? " + "and user_password = ?";

		conn = JmOracleUtil.getConnection();
		User_tVO user = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, userId);
			pst.setString(2, userPass);
			rs = pst.executeQuery();

			while (rs.next()) {
				user = makeUser(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			JmOracleUtil.dbDisconnect(rs, pst, conn);
		}
		return user;
	}

	//회원 정보 업로드
	private User_tVO makeUser(ResultSet rs) throws SQLException {
		User_tVO user = new User_tVO();
		user.setUSER_ID(rs.getString("USER_ID"));
		user.setUSER_PASSWORD(rs.getString("USER_PASSWORD"));
		user.setUSER_NAME(rs.getString("USER_NAME"));
		user.setUSER_EMAIL(rs.getString("USER_EMAIL"));
		user.setUSER_DATE(rs.getDate("USER_DATE"));
		user.setUSER_CALL(rs.getString("USER_CALL"));
		user.setAREA_ID(rs.getInt("AREA_ID"));

		return user;
	}
	
	//개인정보수정
	public int userUpdate(User_tVO user) {
		//User_tVO의 아이디와 일치하는 회원의 정보 업데이트
		String sql = """
				update user_t 
				set user_password = ?, user_name=?,user_email=?,
				user_call=?, area_id=?
				where user_id = ?
				""";
		conn= JmOracleUtil.getConnection();
		
		try {
			pst=conn.prepareStatement(sql);
			
			pst.setString(1, user.getUSER_PASSWORD());
			pst.setString(2, user.getUSER_NAME());
			pst.setString(3, user.getUSER_EMAIL());
			pst.setString(4, user.getUSER_CALL());
			pst.setInt(5, user.getAREA_ID());
			pst.setString(6, user.getUSER_ID());
		
			resultCount = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultCount=-1;
		}finally {
			
			JmOracleUtil.dbDisconnect(null, pst, conn);
		}
		
		
		return resultCount;
	}
}
