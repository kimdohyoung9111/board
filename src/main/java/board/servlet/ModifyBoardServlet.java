package board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class ModifyBoardServlet
 */
@WebServlet("/modifyBoard")
public class ModifyBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf boardService;
       
    public ModifyBoardServlet() {
        super();
        boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		BoardVO boardVO = new BoardVO();
		boardVO = boardService.getBoard(board_seq);
		
		request.setAttribute("boardVO", boardVO);
		RequestDispatcher rd = request.getRequestDispatcher("board/boardForm.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 수정글 업데이트하기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		
		System.out.println("title :::" + title);
		System.out.println("content :::" + content);
		System.out.println("board_seq :::" + board_seq);
		
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_seq(board_seq);
		boardVO.setTitle(title);
		boardVO.setContent(content);
		
		int updateCnt = boardService.updateBoard(boardVO);
		
		if(updateCnt > 0){
			boardVO = boardService.getBoard(board_seq);
			request.setAttribute("boardVO", boardVO);
			RequestDispatcher rd = request.getRequestDispatcher("board/boardVO.jsp");
			rd.forward(request, response);
		}
	}

}
