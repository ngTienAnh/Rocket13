package com.vti.backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.vti.ultis.jdbcUltis;

public class Exercise_1 {
	private jdbcUltis jdbc;
	private Properties property;
	private Connection connection;

	public Exercise_1() throws FileNotFoundException, IOException {
		jdbc = new jdbcUltis();
		property = new Properties();
		property.load(new FileInputStream(
				"C:\\Users\\Admin\\eclipse-workspace\\TestingSystem_Assignment_10_1\\src\\com\\vti\\resources\\database.properties"));
	}

	public void question1() throws ClassNotFoundException, SQLException {
		System.out.println("Thử kết nối");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		String driver = property.getProperty("driver");
		Class.forName(driver);
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("connection successfully!");
	}

	public void question2() throws ClassNotFoundException, SQLException {

		ResultSet popResultSet = jdbc.executeQuery("SELECT * FROM position");

		System.out.println("Thông tin Position đang có trên hệ thống: ");
		String leftAlignFormat = "| %-6d | %-21s |%n";

		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | PositionName          |%n");
		System.out.format("+--------+-----------------------+%n");

		while (popResultSet.next()) {
			System.out.format(leftAlignFormat, popResultSet.getInt(1), popResultSet.getString(2));
			System.out.format("+--------+-----------------------+%n");
		}
	}

	public void question3() throws ClassNotFoundException, SQLException {
		
		PreparedStatement preparedStatement = jdbc.createPrepareStatement("INSERT INTO position (PositionName) VALUES (?);");
		Scanner sc = new Scanner(System.in);
		System.out.printf("Mời nhập Position mới: 1.Dev, 2.Test, 3.Scrum Master, 4.PM ");
		int posIndex = sc.nextInt();
		String pos = "";
		switch (posIndex) {
		case 1:
			pos = "Dev";
			break;
		case 2:
			pos = "Test";
			break;
		case 3:
			pos = "Scrum Master";
			break;
		case 4:
			pos = "PM";
			break;
		default:
			break;
		}
		
		preparedStatement.setString(1, pos);
		if(preparedStatement.executeUpdate() == 1) {
			System.out.println("Nhập thành công");
			question2();
		}
		else System.out.println("Nhập thất bại");
	}
	public void question4() throws ClassNotFoundException, SQLException {
		question2();
		PreparedStatement preparedStatement = jdbc.createPrepareStatement("UPDATE position SET PositionName = ? WHERE (PositionID = ?);");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập id: ");
		int ID = sc.nextInt();
		System.out.println("1.Dev, 2.Test, 3.Scrum Master, 4.PM ");
		System.out.printf("Mời nhập Position mới: ");
		int posIndex = sc.nextInt();
		String pos = "";
		switch (posIndex) {
		case 1:
			pos = "Dev";
			break;
		case 2:
			pos = "Test";
			break;
		case 3:
			pos = "Scrum Master";
			break;
		case 4:
			pos = "PM";
			break;
		default:
			break;
		}
		
		preparedStatement.setString(1, pos);
		preparedStatement.setInt(2, ID);
		if(preparedStatement.executeUpdate() == 1) {
			System.out.println("cập nhật thành công");
			question2();
		}
		else System.out.println("cập nhật thất bại");
	}
	public void question5() throws ClassNotFoundException, SQLException {
		question2();
		PreparedStatement preparedStatement = jdbc.createPrepareStatement("DELETE FROM Position WHERE (PositionID = ?);");
		Scanner sc = new Scanner(System.in);
		System.out.println("Mời nhập id: ");
		int ID = sc.nextInt();
		preparedStatement.setInt(1, ID);
		if(preparedStatement.executeUpdate() == 1) {
			System.out.println("Xóa thành công");
			question2();
		}
		else System.out.println("Xóa thất bại");
	}
}
