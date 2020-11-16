package com.test3;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deptAddProcess2")
public class deptAddProcess2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
	    	String deptId=request.getParameter("DEPT_ID");
	    	String dName=request.getParameter("DNAME");
	    	String loc=request.getParameter("LOC");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:testdb2","scott","tiger");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO dept VALUES(?,?,?)");
			ps.setInt(1, Integer.parseInt(deptId));
			ps.setString(2, dName);
			ps.setString(3, loc);
			int ret = ps.executeUpdate();
//			request.getRequestDispatcher("deptList").forward(request, response);
			response.sendRedirect("deptList");
//			response.setContentType("text/html;charset=utf-8");
//			PrintWriter pw = response.getWriter();
//			pw.println("<html><body>");
//			pw.println("부서가 추가되었습니다.");
//			pw.println("</body></html>");
//			pw.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
			System.out.println(e);
		} finally {
			
		}
	}
}