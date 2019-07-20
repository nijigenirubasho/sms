package sms.service;

import java.sql.SQLException;
import java.util.List;

import sms.dao.impl.StudentDAO;
import sms.pojo.Student;

public class StudentService {

	/**
	 * ����ѧ��
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
	 * ѧ����¼
	 * 
	 * @param student
	 * @return ����¼�ɹ����������ݿ���Ϣ�������Ӧ��ѧ�����󣬷��򷵻ؿ�
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
	 * ��ѯ����ѧ��
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Student> findAllStudent() throws SQLException {
		StudentDAO dao = new StudentDAO();
		return dao.findAll();
	}

	/**
	 * ͨ��IDɾ��ѧ��
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
	 * ͨ��ID����ѧ��
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
	 * �༭ѧ��
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
