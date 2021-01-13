package service;

import javax.servlet.http.HttpServletRequest;

import dto.Bbs;

public interface BoardService {
	
	/**
	 * 게시글 읽기
	 * @param bbs
	 * @return
	 */
	public Bbs detail(Bbs bbs);
	
	
	
	public Bbs andetail(Bbs bbs);
	
	
	
	
	/**
	 * 신규 부서 입력
	 * @param bbs
	 */
	public Bbs noWrite(Bbs param);



	/**
	 * 글작성
	 * @param user_no
	 * @param article_title
	 * @param article_content
	 */
	public void noWrite(int user_no, String article_title, String article_content);
	
	
	
	/**
	 * 
	 * @param article_pw
	 * @param article_title
	 * @param article_content
	 */
	public void anWrite(String article_pw, String article_title, String article_content);
	
	
}
