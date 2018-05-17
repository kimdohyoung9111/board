package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.model.BoardVO;
import board.model.NoticeBoardVO;

public class BoardDao implements BoardDaoInf {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDao() {
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
	* Method : addNoticeBoard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param nbVO
	* @return
	* @throws SQLException
	* Method 설명 : 새로운 게시판 만들기
	*/
	@Override
	public int addNoticeBoard(NoticeBoardVO nbVO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertCnt = sqlSession.insert("board.addNoticeBoard", nbVO);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	/**
	* Method : nboardList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @return
	* @throws SQLException
	* Method 설명 : 전체 리스트 조회
	*/
	@Override
	public List<NoticeBoardVO> nboardList() {
		List<NoticeBoardVO> nbList = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		nbList = sqlSession.selectList("board.nboardList");
		sqlSession.close();
		return nbList;
	}

	/**
	* Method : boardTextList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param nb_seq
	* @return
	* Method 설명 : 해당게시판의 글전체 리스트
	*/
	@Override
	public List<BoardVO> boardTextList(int nb_seq) {
		List<BoardVO> blist = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		blist = sqlSession.selectList("board.boardTextList", nb_seq);
		sqlSession.close();
		return blist;
	}

	/**
	* Method : boardPageList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param page
	* @param pageSize
	* @return
	* Method 설명 : 해당 페이지의 글 리스트
	*/
	@Override
	public List<BoardVO> boardPageList(int page, int pageSize, int nb_seq) {
		Map<String, Integer> paramap = new HashMap<String, Integer>();
		paramap.put("page", page);
		paramap.put("pageSize", pageSize);
		paramap.put("nb_seq", nb_seq);
		List<BoardVO> plist = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		plist = sqlSession.selectList("board.boardPageList", paramap);
		sqlSession.close();
		return plist;
	}

	/**
	* Method : getBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 게시판 글 상세보기
	*/
	@Override
	public BoardVO getBoard(int board_seq) {
		BoardVO boardVO = new BoardVO();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		boardVO = sqlSession.selectOne("board.getBoard", board_seq);
		sqlSession.close();
		return boardVO;
	}

	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param boardVO
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Override
	public int updateBoard(BoardVO boardVO) {
		int updateCnt = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		updateCnt = sqlSession.update("board.updateBoard", boardVO);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	/**
	* Method : deleteBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 게시글 삭제
	*/
	@Override
	public int deleteBoard(int board_seq) {
		int deleteCnt = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		deleteCnt = sqlSession.update("board.deleteBoard", board_seq);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param category_seq
	* @return
	* Method 설명 : 게시글 추가
	*/
	@Override
	public int insertBoard(BoardVO boardVO) {
		int insertCnt = 0;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		insertCnt = sqlSession.insert("board.insertBoard", boardVO);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

}
