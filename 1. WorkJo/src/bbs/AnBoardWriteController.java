package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.SessionDTO;
import dto.common.UserInfo;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/anwrite")
public class AnBoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session = req.getSession();
//		SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");
//		String user_id = (String)req.getAttribute("userid");
		
		HttpSession session = req.getSession();
		session.getAttribute("userinfo");
		UserInfo user_info = (UserInfo)session.getAttribute("userinfo");
		
		System.out.println("요청 성공쓰");
		
		req.getRequestDispatcher("anwrite.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 요청 성공쓰");
		
		req.setCharacterEncoding("UTF-8");
		
//		HttpSession session = req.getSession();
//		SessionDTO user_info = (SessionDTO)session.getAttribute("userinfo");
//		
//		//세션에서 회원정보 갖고오기
//		int user_no = user_info.getUser_no();
//		
//		System.out.println(user_no);
		
		HttpSession session = req.getSession();
		session.getAttribute("userinfo");
		UserInfo user_info = (UserInfo)session.getAttribute("userinfo");
		
		//-------------------------------------
		
		String article_title = req.getParameter("article_title");
		String article_content = req.getParameter("article_content");
		String article_pw = req.getParameter("article_pw");
		
		System.out.println("받아져왔습니까 패워 : " + article_pw);
		
		boardService.anWrite(article_pw, article_title, article_content);
		
		resp.sendRedirect("/anlist");
		
	}

}
