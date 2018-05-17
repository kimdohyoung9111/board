package reply.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import reply.model.ReplyVO;

public class ReplyServiceTest {

	private ReplyServiceInf replyService;
	
	@Before
	public void setting(){
		replyService = new ReplyService();
	}
	
	/**
	* Method : insertReplyTest
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 댓글 추가
	*/
	@Test
	public void insertReplyTest() {
		/***Given***/
		ReplyVO replyVO = new ReplyVO();
		replyVO.setBoard_seq(13);
		replyVO.setMem_id("kim");
		replyVO.setReply_content("세번째 댓글");

		/***When***/
		int insertCnt = replyService.insertReply(replyVO);

		/***Then***/
		assertEquals(1, insertCnt);

	}
	
	/**
	* Method : replyListTest
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 댓글 리스트
	*/
	@Test
	public void replyListTest(){
		/***Given***/
		int board_seq = 13;

		/***When***/
		List<ReplyVO> replyList = replyService.replyList(board_seq);
		
		/***Then***/
		assertNotNull(replyList);

	}
	
	/**
	* Method : deleteReplyTest
	* 최초작성일 : 2018. 5. 16.
	* 작성자 : "K.D.H"
	* 변경이력 :
	* Method 설명 : 댓글 삭제
	*/
	@Test
	public void deleteReplyTest(){
		/***Given***/
		int reply_seq = 5;

		/***When***/
		int deleteCnt = replyService.deleteReply(reply_seq);

		/***Then***/
		assertEquals(1, deleteCnt);

	}

}
