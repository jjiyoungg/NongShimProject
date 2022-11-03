package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.NongShimMemberDAO;
import member.NongShimMemberVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("POST")==false) {
			throw new ServletException("로그인은 POST방식=로그인으로만 들어세용");
		}
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		NongShimMemberVO mvo=NongShimMemberDAO.getInstance().login(id, password);
		String viewPath=null;
		if(mvo==null) {
			viewPath="login/login-fail.jsp";
		}else {
			viewPath="index.jsp";
			HttpSession session=request.getSession();
			session.setAttribute("mvo", mvo);
		}
		
		return viewPath;
	}

}
