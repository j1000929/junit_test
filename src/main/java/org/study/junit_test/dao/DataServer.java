package org.study.junit_test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataServer {

	// db connector
	private Connection conn;

	static final String DB_URL = "jdbc:mysql://192.168.0.212/todo_db?useSSL=no&characterEncoding=utf8";// Secure Socket
	static final String USER_NAME = "jungmin";
	static final String PASSWORD = "joeun911!";

	String username;
	String userpwd;

	public DataServer() {
		makeConnect();
	}

	public void makeConnect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			// Statement statement = conn.createStatement();

			// String sql = "select id, username, userpwd, curr_date, target_date,
			// description from User_Todo";
			//
			// ResultSet rs = statement.executeQuery(sql);
			//
			// while (rs.next()) {
			//
			// int id = rs.getInt(1);
			// String username = rs.getString(2);
			// String userpwd = rs.getString(3);
			// Date curr_date = rs.getDate(4);
			// Date target_date = rs.getDate(5);
			// String description = rs.getString(6);
			//
			// System.out.println("id: " + id);
			// System.out.println("username: " + username);
			// System.out.println("userpwd: " + userpwd);
			// System.out.println("curr_date: " + curr_date);
			// System.out.println("target_date: " + target_date);
			// System.out.println("description: " + description);
			//
			// } // while
			//
			// rs.close();
			// statement.close();
			System.out.println("연결되었습니다.");
			// conn.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public Connection getConn() {
		return conn;
	}

	public boolean login(String username, String userpwd) {

		this.username = username;
		this.userpwd = userpwd;

		Statement statement;
		try {
			statement = conn.createStatement();
			String sql = "select username, userpwd from User_Todo";

			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				if (rs.getString("username").equals(username) && rs.getString("userpwd").equals(userpwd)) {
					return true;
				}
			} // while

			rs.close();
			statement.close();
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateTodo(String username, String todo) {
		return false;
	}

	public String readTod(String username) {
		return null;
	}
}
