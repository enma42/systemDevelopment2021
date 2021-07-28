package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/UserSelectServlet")
public class UserSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//DB接続に使用するクラス
		Connection users = null;
		try {
			users = DBConnection.openConnection();
			//レコードを管理する配列用意
			ArrayList<Member> list = new ArrayList<Member>();
			//SQLを実行するためのクラスを用意
			Statement state = users.createStatement();
			//SELECTした結果を入れるクラスを用意
			ResultSet result = state.executeQuery("SELECT * FROM user_table");
			//次のデータを取り出し、取り出すデータがない場合はfalseを返す
			while (result.next()) {
				String id = result.getString("id");
				String name = result.getString("name");
				String picture = result.getString("picture");
				//Memberクラスに1件ずつレコードを登録
				list.add(new Member(id, name, picture));
			}
			result.close(); //SQLの結果を受け取ったバッファを
			DBConnection.closeConnection(users, state);
			request.setAttribute("list", list);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/select.jsp");
			rd.forward(request, response);
			//クラスが存在しなかったらエラーを表示
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
