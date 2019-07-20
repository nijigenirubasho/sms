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
		log("-ѧ����¼-������-");
		try {
			StudentService studentService = new StudentService();
			String studentAccount = req.getParameter("studentAccount");
			String studentPwd = req.getParameter("studentPwd");
			if (StringUtils.isEmptyOrWhitespaceOnly(studentPwd)
					|| StringUtils.isEmptyOrWhitespaceOnly(studentAccount)) {
				req.setAttribute("student_login_msg", "��¼ʧ�ܣ��û��������붼��׼Ϊ��");
				doGet(req, resp);
				return;
			}
			Student student = new Student();
			student.setStudentAccount(studentAccount);
			student.setStudentPwd(studentPwd);
			System.out.println("�˺�����" + student.getStudentAccount());
			Student resultStudent = studentService.loginStudent(student);
			if (resultStudent != null) {
				HttpSession session = req.getSession();
				session.setAttribute("student", resultStudent);
				log("Ŀǰ��" + SessionCounter.getCount() + "���Ự");
				resp.sendRedirect(req.getContextPath() + "/mainPanel.jsp");
			} else {
				req.setAttribute("student_login_msg", "��¼ʧ�ܣ���ȷ��ѧ�������������Ƿ���ȷ");
				doGet(req, resp);
			}
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("student_login_msg", "��¼ʧ�ܣ��ڲ�����");
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/studentLogin.jsp").forward(req, resp);
	}
}
