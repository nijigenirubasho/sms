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
			log("-增加学生-控制器-");
			StudentService studentService = new StudentService();
			String studentName = req.getParameter("studentName");
			String studentAccount = req.getParameter("studentAccount");
			String studentPwd = req.getParameter("studentPwd");
			if (StringUtils.isEmptyOrWhitespaceOnly(studentPwd)
					|| StringUtils.isEmptyOrWhitespaceOnly(studentAccount)) {
				req.setAttribute("student_add_msg", "失败，用户名和密码都不准为空");
				doGet(req, resp);
				return;
			}
			Student student = new Student();
			student.setStudentName(studentName);
			student.setStudentAccount(studentAccount);
			student.setStudentPwd(studentPwd);
			System.out.println("学生名：" + student.getStudentName());
			boolean flag = studentService.addStudent(student);
			if (flag) {
				req.setAttribute("student_add_msg", "成功");

				Record record = new Record(((Student) req.getSession().getAttribute("student")).getStudentAccount(),
						Type.ADD, student.toString());
				RecordService recordService = new RecordService(req);
				recordService.addRecord(record);
			} else {
				req.setAttribute("student_add_msg", "失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("student_add_msg", "失败，出现异常");
		}
		doGet(req, resp);
	}
}
