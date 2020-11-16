package com.test3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/deptAddProcess")
public class deptAddProcess extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try {
    	 req.setCharacterEncoding("UTF-8");
    	 String deptId=req.getParameter("DEPT_ID");
    	 String dName=req.getParameter("DNAME");
    	 String loc=req.getParameter("LOC");
    	 
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:testdb2","scott","tiger");
         //Insert into dept values(100,' ',20);
         PreparedStatement ps = conn.prepareStatement("Insert into dept values(?,?,?)");
         ps.setInt(1,Integer.parseInt(deptId));
         ps.setString(2,dName);
         ps.setString(3,loc);
         int ret = ps.executeUpdate();
         resp.setContentType("text/html;charset=utf-8");
         PrintWriter pw = resp.getWriter();
         pw.println("<html><body>");
         pw.println("</body></html>");
         pw.close();
         
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

}