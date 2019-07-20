package sms.web.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.util.StringUtils;

import sms.pojo.Record;
import sms.pojo.Record.Type;
import sms.pojo.Student;
import sms.service.RecordService;
import sms.service.StudentService;

@WebServlet(value = "/studentAdd.do")
public class StudentAddController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	Integer id;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/studentAdd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			log("-����ѧ��-������-");
			StudentService studentService = new StudentService();
			String studentName = req.getParameter("studentName");
			String studentAccount = req.getParameter("studentAccount");
			String studentPwd = req.getParameter("studentPwd");
			if (StringUtils.isEmptyOrWhitespaceOnly(studentPwd)
					|| StringUtils.isEmptyOrWhitespaceOnly(studentAccount)) {
				req.setAttribute("student_add_msg", "ʧ�ܣ��û��������붼��׼Ϊ��");
				doGet(req, resp);
				return;
			}
			Student student = new Student();
			student.setStudentName(studentName);
			student.setStudentAccount(studentAccount);
			student.setStudentPwd(studentPwd);
			System.out.println("ѧ������" + student.getStudentName());
			boolean flag = studentService.addStudent(student);
			if (flag) {
				req.setAttribute("student_add_msg", "�ɹ�");

				Record record = new Record(((Student) req.getSession().getAttribute("student")).getStudentAccount(),
						Type.ADD, student.toString());
				RecordService recordService = new RecordService(req);
				recordService.addRecord(record);
			} else {
				req.setAttribute("student_add_msg", "ʧ��");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("student_add_msg", "ʧ�ܣ������쳣");
		}
		doGet(req, resp);
	}
}
