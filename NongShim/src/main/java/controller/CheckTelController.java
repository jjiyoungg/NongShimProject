package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.NongShimMemberDAO;

public class CheckTelController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int tel=Integer.parseInt(request.getParameter("tel"));
		boolean result=NongShimMemberDAO.getInstance().checkTel(tel);
		String message=null;
		if(result) // id가 중복된다는 의미 
			message="fail";
		else // id가 중복되지 않으면 사용할 수 있다는 의미 
			message="ok";
		request.setAttribute("responsebody", message);//AjaxViewServlet이 클라이언트에게 응답하도록 저장 
		return "AjaxView";
	}

}
