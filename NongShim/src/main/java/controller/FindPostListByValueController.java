package controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagination;
import model.ProductPostDAO;

public class FindPostListByValueController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductPostDAO dao = ProductPostDAO.getInstance();
		String checkbox = request.getParameter("checkbox");
		String pageNo=request.getParameter("pageNo");
		Pagination pagination=null;
		int totalPostCount=dao.getTotalPostCount();
		if(pageNo==null) {
			pagination=new Pagination(totalPostCount);
		}else {
			pagination=new Pagination(totalPostCount,Integer.parseInt(pageNo));
		}		
		request.setAttribute("list",dao.findPostListByValue(pagination, checkbox));
		request.setAttribute("pagination", pagination);
		request.setAttribute("url", "productboard/list.jsp");
		
		String[] checkboxlist = {"all","곡물","야채","과일"};
		request.setAttribute("checkboxlist", checkboxlist);
		request.setAttribute("checkedbox", checkbox);
		return "mainpage.jsp";
	}

}
