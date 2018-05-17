package board.service;

import java.util.List;
import java.util.Map;

import board.model.BoardVO;
import board.model.NoticeBoardVO;

public interface BoardServiceInf {
	
	/**
	* Method : addNoticeBoard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param nbVO
	* @return
	* Method 설명 : 새로운 게시판 만들기
	*/
	public int addNoticeBoard(NoticeBoardVO nbVO);

	/**
	* Method : nboardList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시판 조회
	*/
	public List<NoticeBoardVO> nboardList();

	/**
	* Method : boardTextList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param nb_seq
	* @return
	* Method 설명 : 해당게시판의 글전체 리스트
	*/
	public List<BoardVO> boardTextList(int nb_seq);

	
	
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
	public Map<String, Object> boardPageList(int page, int pageSize);

	/**
	* Method : getBoard
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 게시판 글 상세보기
	*/
	public BoardVO getBoard(int board_seq);

	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param boardVO
	* @return
	* Method 설명 : 게시판 글 수정
	*/
	public int updateBoard(BoardVO boardVO);

	/**
	* Method : deleteBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 게시판 글 삭제
	*/
	public int deleteBoard(int board_seq);

	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param boardVO
	* @return
	* Method 설명 : 게시글 작성
	*/
	public int insertBoard(BoardVO boardVO);
}
