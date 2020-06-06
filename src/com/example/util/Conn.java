package com.example.util;
import java.sql.*;

public class Conn {
	private	Connection con=null;
	public Conn() {
		try {
			//1.使用MySql的JDBC驱动程序 
			Class.forName("com.mysql.jdbc.Driver");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getCon(){
		try {
			//2.连接数据库
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sy_user?useUnicode=true&amp;characterEncoding=UTF-8&amp;useSSL=false;serverTimezone=UTC","root","dknight781");
		
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
		return con;
	}
}
