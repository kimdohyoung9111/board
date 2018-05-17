package reply.service;

import java.util.List;

import reply.model.ReplyVO;

public interface ReplyServiceInf {

	/**
	* Method : insertReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param replyVO
	* @return
	* Method 설명 : 댓글 추가
	*/
	public int insertReply(ReplyVO replyVO);

	/**
	* Method : replyList
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param board_seq
	* @return
	* Method 설명 : 댓글 리스트
	*/
	public List<ReplyVO> replyList(int board_seq);

	/**
	* Method : deleteReply
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* @param reply_seq
	* @return
	* Method 설명 : 댓글 삭제
	*/
	public int deleteReply(int reply_seq);
}
