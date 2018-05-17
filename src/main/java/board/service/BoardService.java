package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.dao.BoardDao;
import board.dao.BoardDaoInf;
import board.model.BoardVO;
import board.model.NoticeBoardVO;

public class BoardService implements BoardServiceInf {

	private BoardDaoInf boardDao;
	private int boardCnt;
	private int nb_seq=1;
	
	public BoardService() {
		boardDao = new BoardDao();
	}
	
	/**
	* Method : addNoticeBoard
	* 최초작성일 : 2018. 5. 14.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param nbVO
	* @return
	* Method 설명 : 새로운 게시판 만들기
	*/
	@Override
	public int addNoticeBoard(NoticeBoardVO nbVO) {
		int insertCnt = 0;
		insertCnt = boardDao.addNoticeBoard(nbVO);
		return insertCnt;
	}

	/**
	* Method : nboardList
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시판 조회
	*/
	@Override
	public List<NoticeBoardVO> nboardList() {
		List<NoticeBoardVO> nbList = null;
		nbList = boardDao.nboardList();
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
		this.nb_seq = nb_seq;
		blist = boardDao.boardTextList(nb_seq);
		boardCnt = blist.size();
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
	public Map<String, Object> boardPageList(int page, int pageSize) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<BoardVO> boardList = boardDao.boardPageList(page, pageSize, nb_seq);
		
		String pageNav = makePageNav(page);
		
		resultMap.put("boardList", boardList);
		resultMap.put("pageNav", pageNav);
		
		return resultMap;
	}

	/**
	* Method : makePageNav
	* 최초작성일 : 2018. 5. 15.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param page
	* @param boardCnt2
	* @return
	* Method 설명 : 페이지 네비게이션 생성
	*/
	private String makePageNav(int page) {
		int pageTotalCnt = (int)Math.ceil( (double)(boardCnt)/10);
		
		StringBuffer pageNav = new StringBuffer();
		pageNav.append("<nav>");
		pageNav.append("	<ul class=\"pagination\">");
		pageNav.append("		<li>");
		pageNav.append("			<a href=\"noticeBoard?nb_seq="+ nb_seq +"&page=1&pageSize=10\" aria-label=\"First\"> <span aria-hidden=\"true\">&laquo;</span></a>");
		if(page <= 1){
			pageNav.append("			<a href=\"#\" aria-label=\"Previous\"> <span aria-hidden=\"true\">&lt;</span></a>");
		}else{
			pageNav.append("			<a href=\"noticeBoard?nb_seq="+ nb_seq +"&page="+(page-1)+"&pageSize=10\" aria-label=\"Previous\"> <span aria-hidden=\"true\">&lt;</span></a>");
		}
		pageNav.append("		</li>");
		
		for(int i=1; i<=pageTotalCnt; i++){
			if(page == i){
				pageNav.append("		<li class='active'><a href=\"noticeBoard?nb_seq="+ nb_seq +"&page="+i+"&pageSize=10\">"+ i +"</a></li>");
			}else{
				pageNav.append("		<li><a href=\"noticeBoard?nb_seq="+ nb_seq +"&page="+i+"&pageSize=10\">"+ i +"</a></li>");
			}
		}
		if(page >= pageTotalCnt){
			pageNav.append("		<li><a href=\"#\" aria-label=\"Next\"> <span aria-hidden=\"true\">&gt;</span></a></li>");
		}else{
			pageNav.append("		<li><a href=\"noticeBoard?nb_seq="+ nb_seq +"&page="+(page+1)+"&pageSize=10\" aria-label=\"Next\"> <span aria-hidden=\"true\">&gt;</span></a></li>");
		}
		pageNav.append("		<li><a href=\"noticeBoard?nb_seq="+ nb_seq +"&page="+pageTotalCnt+"&pageSize=10\" aria-label=\"last\"> <span aria-hidden=\"true\">&raquo;</span></a></li>");
		pageNav.append("	</ul>");
		pageNav.append("</nav>");
	
		return pageNav.toString();
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
		return boardDao.getBoard(board_seq);
	}

	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param boardVO
	* @return
	* Method 설명 : 게시판 글 수정
	*/
	@Override
	public int updateBoard(BoardVO boardVO) {
		return boardDao.updateBoard(boardVO);
	}

	/**
	* Method : deleteBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 게시판 글 삭제
	*/
	@Override
	public int deleteBoard(int board_seq) {
		return boardDao.deleteBoard(board_seq);
	}

	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param boardVO
	* @return
	* Method 설명 : 게시글 작성
	*/
	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardDao.insertBoard(boardVO);
	}

}
