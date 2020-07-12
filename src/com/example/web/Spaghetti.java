package com.example.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/spaghetti")
public class Spaghetti extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num_ = request.getParameter("n");
		int num = 0;

		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		
		String result;
		
		if(num%2 != 0)
			result = "홀수";	
		else
			result = "짝수";
		
		request.setAttribute("result", result);
		
		String[] names = {"hyunseok", "dragon"};
		request.setAttribute("names", names);
		
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL은 좋아요");
		request.setAttribute("notice", notice);
		// redirect 일을 새로 요청할 때
		// forword 일을 이어갈 때
		RequestDispatcher dispatcher 
		= request.getRequestDispatcher("spaghetti.jsp");
		dispatcher.forward(request, response);
		
	}
}
