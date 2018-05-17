package board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.NoticeBoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;

/**
 * Servlet implementation class InsertNboardServlet
 */
@WebServlet("/insertNboard")
public class InsertNboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardServiceInf boardService;
	
    public InsertNboardServlet() {
        super();
        boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String nb_name = request.getParameter("nb_name");
		String mem_id = request.getParameter("mem_id");
		
		List<NoticeBoardVO> nbList = boardService.nboardList();
		for(NoticeBoardVO vo : nbList){
			if(vo.getNb_name().equals(nb_name)){
				request.setAttribute("error", "error");
				RequestDispatcher rd = request.getRequestDispatcher("board/nboardForm.jsp");
				rd.forward(request, response);
				return;
			}
		}
		NoticeBoardVO nbVO = new NoticeBoardVO();
		nbVO.setMem_id(mem_id);
		nbVO.setNb_name(nb_name);
		
		int insertCnt = boardService.addNoticeBoard(nbVO);
		
		if(insertCnt > 0){
			request.setAttribute("nb_name", nb_name);
			nbList = boardService.nboardList();
			HttpSession session = request.getSession();
			session.setAttribute("nbList", nbList);
			RequestDispatcher rd = request.getRequestDispatcher("board/main.jsp");
			rd.forward(request, response);
		}
		
	}

}
