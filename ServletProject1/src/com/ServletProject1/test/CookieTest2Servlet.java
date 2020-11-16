package com.ServletProject1.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie2")
public class CookieTest2Servlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws
												ServletException, IOException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		Cookie[] list = req.getCookies();
		for (int i = 0; list!=null && i<list.length; i++) {
			out.println(list[i].getName()+" : "+list[i].getValue()+"<br>");
		}

		out.close();
	}
}
