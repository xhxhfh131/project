package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Bbs;
import dto.SessionDTO;
import dto.common.UserInfo;
import service.BoardService;
import service.BoardServiceImpl;

@WebServlet("/anboard")
public class AnBoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		HttpSession session = req.getSession();
//		String user_id = (String)req.getAttribute("userid");
//		SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");
//		System.out.println("여기는 board view의 : " + session.getAttribute("userinfo"));
		
		HttpSession session = req.getSession();
		session.getAttribute("userinfo");
		UserInfo user_info = (UserInfo)session.getAttribute("userinfo");
		
		String param = req.getParameter("ana");
		
		System.out.println("/board param - " + param);
		
		int article_no = 0;
		if(param!=null && !"".equals(param)) {
			article_no = Integer.parseInt(param);
		}
		
		
		Bbs bbs = new Bbs();
		bbs.setArticle_no(article_no);
		
		Bbs res = boardService.andetail(bbs);
		
		System.out.println("디스이즈an글번호 : " + bbs.getArticle_no());
		
		req.setAttribute("result", res);
		
		req.getRequestDispatcher("anview.jsp").forward(req, resp);
		
		
	}

}
