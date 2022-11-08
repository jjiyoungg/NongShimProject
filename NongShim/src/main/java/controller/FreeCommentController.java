package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.NongShimMemberVO;
import model.FreeCommentDAO;
import model.ProductPostDAO;

public class FreeCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session=request.getSession(false);
		NongShimMemberVO mvo=(NongShimMemberVO) session.getAttribute("mvo");
		String id = mvo.getId();
		
		String nick=mvo.getNickName();
		long no=Long.parseLong(request.getParameter("postno"));
		String comment= request.getParameter("comment");
		
		
		FreeCommentDAO.getInstance().addComment(id, nick, no, comment);              
		//request.setAttribute("url", "ProductDetailController");
		return "redirect:FindFreePostDetailController.do?post_No="+no;
		
	}

}
