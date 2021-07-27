package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInsertServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection users = null;
			try {
			request.setCharacterEncoding("utf-8");
			Class.forName("com.mysql.jdbc.Driver");
			users = DriverManager.getConnection("jdbc:mysql://localhost/servlet_db?useUnicode=true&characterEncoding=utf8","root","");
			String id = request.getParameter("insertId");
			String name = request.getParameter("insertName");
			String picture = request.getParameter("insertPicture");
			Statement state = users.createStatement();
			state.executeUpdate("INSERT INTO user_table VALUE('" + id + "','" + name +
			"','" + picture + "')");
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
