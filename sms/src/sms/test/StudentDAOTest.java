package sms.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import sms.dao.impl.StudentDAO;
import sms.pojo.Student;

class StudentDAOTest {

	/**
	 * JUnit �ķ���Ҫ�� 1.�����з������� 2.������һ����Ա��ͨ���������ܼ��κ������ؼ��֣��� static\final 3.���������в���
	 * 4.��������Ҫ����@Test ע��
	 */

	@Test
	public void insert() {
		//assertTrue(false, "�������������ݣ�");
		String testName = "����", testAccount = "zhangsan";
		StudentDAO studentDAO = new StudentDAO();
		Student entity = new Student();
		entity.setStudentName(testName);
		entity.setStudentAccount(testAccount);
		try {
			int insert = studentDAO.insert(entity);
			System.out.println(insert);
			// ɾ����������
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
			System.out.println("ѧ������" + student.getStudentName());
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
			assertNotNull(students, "ѧ������Ϊ��");
			assertNotEquals(0, students.size(), "ѧ�������б�Ϊ��");
			for (Student student : students) {
				assertNotNull(student);
				System.out.println(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			fail("SQL�쳣", e);
		}
	}
}
