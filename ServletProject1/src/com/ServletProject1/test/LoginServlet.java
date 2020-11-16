package com.ServletProject1.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      res.setContentType("text/html;charset=UTF-8" );
      PrintWriter pw = res.getWriter();
      String name =req.getParameter("name");
      String password = req.getParameter("password");
      
      if(password.equals("1234") && name.equals("admin")) {
            pw.println("로그인 하셨습니다. 감사합니다. ");
            Cookie ck = new Cookie("name", name);
            res.addCookie(ck);
         } else {
            pw.println("로그인 정보를 다시 확인해주세요.");
         }
         
      pw.close();
   }

}