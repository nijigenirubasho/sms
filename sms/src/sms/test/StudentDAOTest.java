package sms.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import sms.dao.impl.StudentDAO;
import sms.pojo.Student;

class StudentDAOTest {

	/**
	 * JUnit 的方法要求 1.不能有返回类型 2.必须是一个成员普通方法、不能加任何其他关键字，如 static\final 3.方法不能有参数
	 * 4.方法必须要加上@Test 注解
	 */

	@Test
	public void insert() {
		//assertTrue(false, "跳过（保护数据）");
		String testName = "张三", testAccount = "zhangsan";
		StudentDAO studentDAO = new StudentDAO();
		Student entity = new Student();
		entity.setStudentName(testName);
		entity.setStudentAccount(testAccount);
		try {
			int insert = studentDAO.insert(entity);
			System.out.println(insert);
			// 删除测试数据
			studentDAO.deleteById(studentDAO.findByAccount(testAccount).getStudentId());
		} catch (SQLException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@Test
	public void findByAccount() {
		StudentDAO studentDAO = new StudentDAO();
		try {
			Student student = studentDAO.findByAccount("lisi");
			System.out.println("学生名：" + student.getStudentName());
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
			fail(e);
		}
	}

	@Test
	public void findAll() {
		StudentDAO dao = new StudentDAO();
		List<Student> students;
		try {
			students = dao.findAll();
			assertNotNull(students, "学生数据为空");
			assertNotEquals(0, students.size(), "学生数据列表为空");
			for (Student student : students) {
				assertNotNull(student);
				System.out.println(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			fail("SQL异常", e);
		}
	}
}
