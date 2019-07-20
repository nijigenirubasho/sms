package sms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	/**
	 * ȡ�����ӣ�ע�������Ѿ�Ԥ�������ݿ�������Ϣ
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
	 * ȡ������
	 * 
	 * @param driver   ������
	 * @param url      ����
	 * @param user     �û���
	 * @param password ����
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
