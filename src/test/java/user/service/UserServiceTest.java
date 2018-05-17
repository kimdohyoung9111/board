package user.service;

import static org.junit.Assert.*;

import org.junit.Test;

import user.model.UserVO;

public class UserServiceTest {

	/**
	* Method : userLoginTest
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 로그인시 회원인지 검색
	*/
	@Test
	public void userLoginTest() {
		/***Given***/
		UserServiceInf userService = new UserService();
		String userId = "sally";
		String pass = "1234";
		UserVO userVO = new UserVO();
		userVO.setMem_id(userId);
		userVO.setMem_pass(pass);

		/***When***/
		userVO = userService.userLogin(userVO);
		
		/***Then***/
		assertEquals(userId, userVO.getMem_id());

	}

}
