package sms.web.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.util.StringUtils;

import sms.pojo.Student;
import sms.service.StudentService;
import sms.web.listener.SessionCounter;

@WebServlet(value = "/studentLogin.do")
public class StudentLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("-学生登录-控制器-");
		try {
			StudentService studentService = new StudentService();
			String studentAccount = req.getParameter("studentAccount");
			String studentPwd = req.getParameter("studentPwd");
			if (StringUtils.isEmptyOrWhitespaceOnly(studentPwd)
					|| StringUtils.isEmptyOrWhitespaceOnly(studentAccount)) {
				req.setAttribute("student_login_msg", "登录失败，用户名和密码都不准为空");
				doGet(req, resp);
				return;
			}
			Student student = new Student();
			student.setStudentAccount(studentAccount);
			student.setStudentPwd(studentPwd);
			System.out.println("账号名：" + student.getStudentAccount());
			Student resultStudent = studentService.loginStudent(student);
			if (resultStudent != null) {
				HttpSession session = req.getSession();
				session.setAttribute("student", resultStudent);
				log("目前有" + SessionCounter.getCount() + "个会话");
				resp.sendRedirect(req.getContextPath() + "/mainPanel.jsp");
			} else {
				req.setAttribute("student_login_msg", "登录失败，请确认学生名或者密码是否正确");
				doGet(req, resp);
			}
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("student_login_msg", "登录失败，内部错误");
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/studentLogin.jsp").forward(req, resp);
	}
}
