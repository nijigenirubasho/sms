package sms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	/**
	 * 取得链接，注意这里已经预设了数据库链接信息
	 * 
	 * @return {@link Connection}
	 */
	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/table1?serverTimezone=UTC";
		String user = "root";
		String password = "0";
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 取得链接
	 * 
	 * @param driver   驱动类
	 * @param url      链接
	 * @param user     用户名
	 * @param password 密码
	 * @return  {@link Connection}
	 */
	public static Connection getConnection(String driver, String url, String user, String password) {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
