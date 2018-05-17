package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.model.UserVO;

public class UserDao implements UserDaoInf {

	private SqlSessionFactory sqlSessionFactory;
	
	public UserDao() {
		String resource = "mybatis/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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
	@Override
	public UserVO userLogin(UserVO UserVO) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserVO vo = sqlSession.selectOne("user.userLogin", UserVO);
		sqlSession.close();
		return vo;
	}

}
