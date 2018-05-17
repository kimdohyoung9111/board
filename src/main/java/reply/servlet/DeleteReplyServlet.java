package reply.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;
import reply.model.ReplyVO;
import reply.service.ReplyService;
import reply.service.ReplyServiceInf;

/**
 * Servlet implementation class DeleteReplyServlet
 */
@WebServlet("/deleteReply")
public class DeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReplyServiceInf replyService;
	private BoardServiceInf boardService;
       
    public DeleteReplyServlet() {
        super();
        replyService = new ReplyService();
        boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reply_seq = Integer.parseInt(request.getParameter("reply_seq"));
		
		int deleteCnt = replyService.deleteReply(reply_seq);
		
		if(deleteCnt > 0){
			int board_seq = Integer.parseInt(request.getParameter("board_seq"));
			BoardVO boardVO = boardService.getBoard(board_seq);
			request.setAttribute("boardVO", boardVO);
			// 댓글 리스트 불러오기
			List<ReplyVO> replyList = new ArrayList<ReplyVO>();
			replyList = replyService.replyList(board_seq);
			request.setAttribute("replyList", replyList);
			// boardVO.jsp 가기
			RequestDispatcher rd = request.getRequestDispatcher("board/boardVO.jsp");
			rd.forward(request, response);
		}
	}

}
