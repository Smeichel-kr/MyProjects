package com.ServletProject1.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/MyTestDatabase")
public class MyTestDatabase extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:testdb2","scott","tiger");
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept");
         ResultSet rs = ps.executeQuery();
         resp.setContentType("text/html;charset=utf-8");
         PrintWriter pw = resp.getWriter();
         pw.println("<html><body>");
         while(rs.next()) {
            pw.print(rs.getString("DNAME"));
            pw.print("\t");
            pw.println(rs.getString("LOC") + "<br>");
         }
         rs.close();
         pw.println("</body></html>");
         pw.close();
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }

}