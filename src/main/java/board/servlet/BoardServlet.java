package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reply.model.ReplyVO;
import reply.service.ReplyService;
import reply.service.ReplyServiceInf;
import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/getBoard")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf boardService;
	private ReplyServiceInf replyService;
       
    public BoardServlet() {
        super();
        boardService = new BoardService();
        replyService = new ReplyService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		BoardVO boardVO = boardService.getBoard(board_seq);
		
		// 댓글 리스트
		List<ReplyVO> replyList = replyService.replyList(board_seq);
		request.setAttribute("replyList", replyList);
		//System.out.println("댓글 리스트 :::: " + replyList);
		
		request.setAttribute("boardVO", boardVO);
		RequestDispatcher rd = request.getRequestDispatcher("board/boardVO.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
