package sms.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sms.util.DBUtils;

class DBUtilsTest {

	@Test
	void getConnection() {
		String string = DBUtils.getConnection().toString();
		System.out.println(string);
		assertNotNull(string);
		// 自定义数据库测试
		assertNotNull(DBUtils.getConnection("com.mysql.jc.jdbc.Driver",
				"jdbc:mysql://localhost:3306/table1?serverTimezone=UTC", "root", "0"));
	}
}
