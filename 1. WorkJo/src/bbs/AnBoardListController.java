package bbs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Paging;
import dto.Bbs;
import dto.SessionDTO;
import dto.common.UserInfo;
import service.NoBoardService;
import service.NoBoardServiceImpl;

@WebServlet("/anlist")
public class AnBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoBoardService noBoardService = new NoBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//------------------------------------세션
//		HttpSession session = req.getSession();
//		session.getAttribute("userinfo");
//			
//		System.out.println("여기는 board 리스트의 : " + session.getAttribute("userinfo"));
		
//		HttpSession session = req.getSession();
//		String user_id = (String)req.getAttribute("userid");
//		SessionDTO user_info = (SessionDTO) session.getAttribute("userinfo");
//		System.out.println("여기는 board view의 : " + session.getAttribute("userinfo"));
		
		HttpSession session = req.getSession();
		session.getAttribute("userinfo");
		UserInfo user_info = (UserInfo)session.getAttribute("userinfo");

		
		//페이징 정보 생성하기
		Paging paging = noBoardService.angetPaging(req);
		
		//Paging처리 결과 MODEL값 전달
		req.setAttribute("paging", paging);
		
		
		//게시글 전체 조회
		List<Bbs> list = noBoardService.angetList(paging);
		
//		System.out.println("리스트 왜안뜨노 진자ㅡㅡ : " + list);
				
		//조회결과 MODEL값으로 전달
		req.setAttribute("list", list);
				
//		System.out.println("전달 : " + list);
				
		//VIEW 지정 응답
		req.getRequestDispatcher("/anbbs.jsp").forward(req, resp);
			
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		
		
	}

}
