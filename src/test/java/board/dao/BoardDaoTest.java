package board.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import board.model.BoardVO;
import board.model.NoticeBoardVO;

public class BoardDaoTest {

	private BoardDaoInf boardDao;
	
	@Before
	public void setting(){
		boardDao = new BoardDao();
	}
	
	/**
	* Method : addNoticeBoardTest
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 새로운 게시판 만들기
	 * @throws SQLException 
	*/
	@Test
	public void addNoticeBoardTest() {
		/***Given***/
		NoticeBoardVO nbVO = new NoticeBoardVO();
		nbVO.setMem_id("sally");
		nbVO.setNb_name("test2");

		/***When***/
		int insertCnt = boardDao.addNoticeBoard(nbVO);
		
		/***Then***/
		assertEquals(1, insertCnt);

	}
	
	/**
	* Method : nboardListTest
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 전체 게시판 조회
	 * @throws SQLException 
	*/
	@Test
	public void nboardListTest(){
		/***Given***/
		
		/***When***/
		List<NoticeBoardVO> nbList = boardDao.nboardList();

		/***Then***/
		assertNotNull(nbList);

	}
	
	/**
	* Method : boardTextList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param nb_seq
	* Method 설명 : 해당게시판의 글전체 리스트
	 * @throws SQLException 
	*/
	@Test
	public void boardTextList(){
		/***Given***/
		int nb_seq = 1;

		/***When***/
		List<BoardVO> blist = boardDao.boardTextList(nb_seq);
		
		/***Then***/
		assertNotNull(blist);
		assertEquals(2, blist.size());

	}
	
	/**
	* Method : boardPageList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 해당 페이지의 글 리스트
	*/
	@Test
	public void boardPageList(){
		/***Given***/
		int page = 1;
		int pageSize = 10;
		int nb_seq = 1;

		/***When***/
		List<BoardVO> plist = boardDao.boardPageList(page, pageSize, nb_seq);
		
		/***Then***/
		assertNotNull(plist);

	}
	
	/**
	* Method : getBoardTest
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 게시판 글 상세보기 
	*/
	@Test
	public void getBoardTest(){
		/***Given***/
		int board_seq = 1;

		/***When***/
		BoardVO boardVO = boardDao.getBoard(board_seq);

		/***Then***/
		assertNotNull(boardVO);

	}
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 게시글 수정
	*/
	@Test
	public void updateBoard(){
		/***Given***/
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_seq(13);
		boardVO.setTitle("제목변경2");
		boardVO.setContent("내용도 변경2");

		/***When***/
		int updateCnt = boardDao.updateBoard(boardVO);
		
		/***Then***/
		assertEquals(1, updateCnt);
		
	}
	
	/**
	* Method : deleteBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 게시글 삭제
	*/
	@Test
	public void deleteBoard(){
		/***Given***/
		int board_seq = 12;

		/***When***/
		int deleteCnt = boardDao.deleteBoard(board_seq);

		/***Then***/
		assertEquals(1, deleteCnt);

	}
	
	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 게시글 추가
	*/
	@Test
	public void insertBoard(){
		/***Given***/
		BoardVO boardVO = new BoardVO();
		boardVO.setCategory_seq(1);
		boardVO.setTitle("새 글");
		boardVO.setContent("새 내용");
		boardVO.setReg_id("sally");

		/***When***/
		int insertCnt = boardDao.insertBoard(boardVO);

		/***Then***/
		assertEquals(1, insertCnt);

	}

}
