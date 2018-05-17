package user.servlet;

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
import javax.websocket.Session;

import board.model.NoticeBoardVO;
import board.service.BoardService;
import board.service.BoardServiceInf;
import user.model.UserVO;
import user.service.UserService;
import user.service.UserServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceInf userService;
	private BoardServiceInf boardService;
       
    public LoginServlet() {
        super();
        userService = new UserService();
        boardService = new BoardService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String userpass = request.getParameter("password");
		//String remember = request.getParameter("remember"); // 체크박스 체크시 remember라는 값이 온다.(안하면 null)
		
		UserVO userVO = new UserVO();
		userVO.setMem_id(userId);
		userVO.setMem_pass(userpass);

		List<NoticeBoardVO> nbList = new ArrayList<NoticeBoardVO>();
		
		nbList = boardService.nboardList();
		userVO = userService.userLogin(userVO);
		
		if(userVO != null){
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO);
			session.setAttribute("nbList", nbList);
			RequestDispatcher rd = request.getRequestDispatcher("board/main.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("userId", userId);
			RequestDispatcher rd = request.getRequestDispatcher("login/login.jsp");
			rd.forward(request, response);
		}
		
	}

}
