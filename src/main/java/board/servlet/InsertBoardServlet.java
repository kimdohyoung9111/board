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

import board.model.BoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;
import user.model.UserVO;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/insertBoard")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardServiceInf boardService;
       
    public InsertBoardServlet() {
        super();
        boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("boardTitle");
		String content = request.getParameter("smarteditor");
		String reg_id = request.getParameter("mem_id");
		
		HttpSession session = request.getSession();
		int category_seq = (int) session.getAttribute("nb_seq");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setCategory_seq(category_seq);
		boardVO.setContent(content);
		boardVO.setReg_id(reg_id);
		boardVO.setTitle(title);
		
		int insertCnt = boardService.insertBoard(boardVO);
		
		if(insertCnt > 0){
			boardService.boardTextList(category_seq);
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
		
	}

}
