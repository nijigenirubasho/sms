package sms.service;

import java.sql.SQLException;
import java.util.List;

import sms.dao.impl.StudentDAO;
import sms.pojo.Student;

public class StudentService {

	/**
	 * 增加学生
	 * 
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	public boolean addStudent(Student student) throws SQLException {
		StudentDAO studentDAO = new StudentDAO();
		int count = studentDAO.insert(student);
		return count > 0;
	}

	/**
	 * 学生登录
	 * 
	 * @param student
	 * @return 若登录成功，根据数据库信息返回相对应的学生对象，否则返回空
	 * @throws SQLException
	 */
	public Student loginStudent(Student student) throws SQLException {
		StudentDAO dao = new StudentDAO();
		Student resultStudent = dao.findByAccount(student.getStudentAccount());
		if (resultStudent != null) {
			if (resultStudent.getStudentPwd().equals(student.getStudentPwd()))
				return resultStudent;
		}
		return null;
	}

	/**
	 * 查询所有学生
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Student> findAllStudent() throws SQLException {
		StudentDAO dao = new StudentDAO();
		return dao.findAll();
	}

	/**
	 * 通过ID删除学生
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteStudentById(Integer studentId) throws SQLException {
		StudentDAO studentDAO = new StudentDAO();
		int count = studentDAO.deleteById(studentId);
		return count > 0;
	}

	/**
	 * 通过ID查找学生
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Student findStudentById(int id) throws SQLException {
		StudentDAO dao = new StudentDAO();
		return dao.findById(id);
	}

	/**
	 * 编辑学生
	 * 
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	public int editStudent(Student student) throws SQLException {
		StudentDAO dao = new StudentDAO();
		return dao.updateForNotNull(student);
	}
}
