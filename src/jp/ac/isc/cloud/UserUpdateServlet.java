package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection users = null;
			try {
			request.setCharacterEncoding("utf-8");
			Class.forName("com.mysql.jdbc.Driver");
			users = DriverManager.getConnection("jdbc:mysql://localhost/servlet_db?useUnicode=true&characterEncoding=utf8","root","");
			String id = request.getParameter("updateId");
			String name = request.getParameter("updateName");
			String picture = request.getParameter("updatePicture");
			Statement state = users.createStatement();
			state.executeUpdate("UPDATE user_table SET name='" + name + "',picture='"+ picture+"'WHERE id='" + id+"'");
			state.close();
			users.close();
			response.sendRedirect("/select"); //UserSelectServletを呼び出す
			}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}
			}catch(SQLException e){
			e.printStackTrace();
			}
	}
	}

