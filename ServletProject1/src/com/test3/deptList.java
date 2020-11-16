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

@WebServlet("/deptList")
public class deptList extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = 
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:testdb2","scott","tiger");
			// SELECT * FROM dept;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM dept");
			ResultSet rs = ps.executeQuery();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<html><body>");
			while(rs.next()) {
				pw.println(rs.getInt("DEPTNO") + ",");
				pw.println(rs.getString("DNAME") + ",");
				pw.println(rs.getString("LOC") + "<br>");
			}
			rs.close();
			pw.println("</body></html>");
			pw.close();
			conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
	
	}
}