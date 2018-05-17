package reply.service;

import java.util.List;

import reply.dao.ReplyDao;
import reply.dao.ReplyDaoInf;
import reply.model.ReplyVO;

public class ReplyService implements ReplyServiceInf {

	private ReplyDaoInf replyDao;
	
	public ReplyService() {
		replyDao = new ReplyDao();
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
		return replyDao.insertReply(replyVO);
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
		return replyDao.replyList(board_seq);
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
		return replyDao.deleteReply(reply_seq);
	}

}
