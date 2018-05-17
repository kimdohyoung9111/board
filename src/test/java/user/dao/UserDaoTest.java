package user.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import user.dao.UserDao;
import user.dao.UserDaoInf;
import user.model.UserVO;

public class UserDaoTest {

	/**
	* Method : userLoginTest
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 로그인시 회원인지 검색
	 * @throws SQLException 
	*/
	@Test
	public void userLoginTest() throws SQLException {
		/***Given***/
		UserDaoInf userDao = new UserDao();
		String userId = "sally";
		String pass = "1234";
		UserVO userVO = new UserVO();
		userVO.setMem_id(userId);
		userVO.setMem_pass(pass);

		/***When***/
		userVO = userDao.userLogin(userVO);
		
		/***Then***/
		assertEquals(userId, userVO.getMem_id());

	}

}
