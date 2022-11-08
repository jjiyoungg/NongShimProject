package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import member.NongShimMemberVO;
import model.MyPageDAO;

public class MyPageTodayLottoMoneyController implements Controller {

	@SuppressWarnings("unchecked")
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		
		ArrayList<Integer> list=(ArrayList<Integer>) session.getAttribute("lottoNum");

		//session의 아이디를 저장해놓고 블락
		System.out.println(list.toString());
		
		request.setAttribute("num5", list.get(0));
		request.setAttribute("num4", list.get(1));
		request.setAttribute("num3", list.get(2));
		request.setAttribute("num2", list.get(3));
		request.setAttribute("num1", list.get(4));
		request.setAttribute("url", "mypage/7pointLotto.jsp");
		return "mainpage.jsp";
	}

}
