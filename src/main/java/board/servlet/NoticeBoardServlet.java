package board.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class NoticeBoardServlet
 */
@WebServlet("/noticeBoard")
public class NoticeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf boardService;
       
    public NoticeBoardServlet() {
        super();
        boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//noticeBoard?nb_seq=1
		int nb_seq = Integer.parseInt(request.getParameter("nb_seq"));
		
		HttpSession session = request.getSession();
		session.setAttribute("nb_seq", nb_seq);
		
		boardService.boardTextList(nb_seq);
		
		String pageString = request.getParameter("page");
		int page = pageString == null ? 1 : Integer.parseInt(pageString); 
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString); 
		
		Map<String, Object> resultMap = boardService.boardPageList(page, pageSize);
		
		request.setAttribute("boardList", resultMap.get("boardList"));
		request.setAttribute("pageNav", resultMap.get("pageNav"));
		
		RequestDispatcher rd = request.getRequestDispatcher("board/boardList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
