package user.service;

import java.sql.SQLException;

import user.dao.UserDao;
import user.dao.UserDaoInf;
import user.model.UserVO;

public class UserService implements UserServiceInf {

	private UserDaoInf userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	/**
	* Method : userLogin
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param userVO
	* @return
	* Method 설명 : 로그인시 회원인지 검색
	*/
	@Override
	public UserVO userLogin(UserVO userVO) {
		UserVO vo = new UserVO();
		try {
			vo = userDao.userLogin(userVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

}
