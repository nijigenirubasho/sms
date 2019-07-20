package sms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sms.dao.DAO;
import sms.pojo.Student;
import sms.util.DBUtils;

public class StudentDAO implements DAO<Student> {

	@Override
	public int insert(Student entity) throws SQLException {
		Connection connection = DBUtils.getConnection();
		String sql = "INSERT INTO tb_student (student_name, student_account, student_pwd) VALUES (?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, entity.getStudentName());
		statement.setString(2, entity.getStudentAccount());
		statement.setString(3, entity.getStudentPwd());
		int col = statement.executeUpdate();
		statement.close();
		connection.close();
		return col;
	}

	/**
	 * 根据账号名返回唯一的学生信息
	 * 
	 * @param studentAccount
	 * @return
	 * @throws SQLException
	 */
	public Student findByAccount(String studentAccount) throws SQLException {
		return find("student_account", studentAccount);
	}

	public Student findById(int id) throws SQLException {
		return find("student_id", id);
	}

	private Student find(String type, Object index) throws SQLException {
		String sql = String.format("SELECT * FROM tb_student WHERE %s=?", type);
		Connection connection = DBUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setObject(1, index);
		ResultSet rs = statement.executeQuery();
		Student student = null;
		if (rs != null) {
			if (rs.next()) {
				student = new Student();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setStudentAccount(rs.getString("student_account"));
				student.setStudentPwd(rs.getString("student_pwd"));
			}
			rs.close();
		}
		statement.close();
		connection.close();
		return student;
	}

	@Override
	public List<Student> findAll() throws SQLException {
		String sql = "SELECT * FROM tb_student";
		List<Student> students = new ArrayList<>();
		Connection conn = DBUtils.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setStudentName(rs.getString("student_name"));
			student.setStudentAccount(rs.getString("student_account"));
			student.setStudentPwd(rs.getString("student_pwd"));
			students.add(student);
		}
		rs.close();
		ps.close();
		conn.close();
		return students;
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		// 1.获得数据库连接
		Connection conn = DBUtils.getConnection();
		String sql = "DELETE FROM tb_student WHERE student_id=?"; // 2.获得操作对象
		PreparedStatement ps = conn.prepareStatement(sql); // 设置参数
		ps.setInt(1, id);
		// 3.操作-插入
		int count = ps.executeUpdate();
		ps.close();
		conn.close(); // 4.关闭
		return count;
	}

	/**
	 * 更新学生非空的字段，通过编号
	 * 
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	public int updateForNotNull(Student student) throws SQLException {
		String sql = "UPDATE tb_student SET ";
		StringBuilder builder = new StringBuilder(sql);
		if (student.getStudentName() != null) {
			builder.append("student_name='" + student.getStudentName() + "',");
		}
		if (student.getStudentAccount() != null) {
			builder.append("student_account='" + student.getStudentAccount() + "',");
		}
		if (student.getStudentPwd() != null) {
			builder.append("student_pwd='" + student.getStudentPwd() + "',");
		}
		builder.delete(builder.length() - 1, builder.length());
		builder.append(" WHERE  student_id=" + student.getStudentId());
		Connection connection = DBUtils.getConnection();
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate(builder.toString());
		statement.close();
		connection.close();
		return count;
	}
}
