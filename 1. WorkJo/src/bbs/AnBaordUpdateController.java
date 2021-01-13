package bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Bbs;
import dto.common.UserInfo;

@WebServlet("/anmodify")
public class AnBaordUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.getAttribute("userinfo");
		UserInfo user_info = (UserInfo)session.getAttribute("userinfo");
		
		String ar_no = req.getParameter("article_no");
		int article_no = Integer.parseInt(ar_no);
//		System.out.println("개빡치는 글넘버 : " + article_no);
		System.out.println("------------------------" + ar_no);
		
		BbsDAO bbsDao = BbsDAO.getInstance();
		Bbs bbs = new Bbs();
		bbs = bbsDao.anselectByNo(article_no);
		
		
		
	}

}
