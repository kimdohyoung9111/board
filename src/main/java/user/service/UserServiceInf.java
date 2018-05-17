package user.service;

import java.sql.SQLException;

import user.model.UserVO;

public interface UserServiceInf {
	
	/**
	* Method : userLogin
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param uvo
	* @return
	* @throws SQLException
	* Method 설명 : 로그인시 회원인지 검색
	*/
	public UserVO userLogin(UserVO userVO);
}
