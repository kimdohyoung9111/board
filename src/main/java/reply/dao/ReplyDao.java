package reply.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import reply.model.ReplyVO;

public class ReplyDao implements ReplyDaoInf {

	private SqlSessionFactory sqlSessionFactory;
	
	public ReplyDao() {
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
	* Method : insertReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param replyVO
	* @return
	* Method 설명 : 댓글 추가
	*/
	@Override
	public int insertReply(ReplyVO replyVO) {
		int insertCnt = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		insertCnt = sqlSession.insert("reply.insertReply", replyVO);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	/**
	* Method : replyList
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 댓글 리스트
	*/
	@Override
	public List<ReplyVO> replyList(int board_seq) {
		List<ReplyVO> replyList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		replyList = sqlSession.selectList("reply.replyList", board_seq);
		sqlSession.close();
		return replyList;
	}

	/**
	* Method : deleteReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param reply_seq
	* @return
	* Method 설명 : 댓글 삭제
	*/
	@Override
	public int deleteReply(int reply_seq) {
		int deleteCnt = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		deleteCnt = sqlSession.delete("reply.deleteReply", reply_seq);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

}
