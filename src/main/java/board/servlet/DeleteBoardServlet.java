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
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet("/deleteBoard")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf boardService;
       
    public DeleteBoardServlet() {
        super();
        boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int board_seq = Integer.parseInt(request.getParameter("board_seq"));
		int deleteCnt = boardService.deleteBoard(board_seq);
		
		if(deleteCnt > 0){
			BoardVO boardVO = boardService.getBoard(board_seq);
			request.setAttribute("boardVO", boardVO);
			RequestDispatcher rd = request.getRequestDispatcher("board/main.jsp");
			rd.forward(request, response);
		}
	}

}
