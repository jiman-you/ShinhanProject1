package jmproject.service;

import java.util.List;

import jmproject.model.User_tDAO;
import jmproject.vo.User_tVO;

public class User_tService {
	User_tDAO userDao = new User_tDAO();
	//신규유저등록
	public String UserInsert(User_tVO user) {
		int result = userDao.UserInsert(user);
		
		return (result>0?"회원가입완료":"회원가입실패");
	}
	//로그인
	public User_tVO UserLogin(String userName,String userPass) {
	 
		return userDao.UserLogin(userName, userPass);
	}
	//관리자 로그인
	public User_tVO AdminLogin(String userId, String userPass) {
		
		return userDao.AdminLogin(userId, userPass);
	}
	//개인정보수정
	public String userUpdate(User_tVO user) {
		int result = userDao.userUpdate(user);
		
		return (result>0?"개인정보수정성공":"개인정보수정실패");
		
	}
}
