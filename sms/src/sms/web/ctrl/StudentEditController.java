package sms.web.ctrl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sms.pojo.Record;
import sms.pojo.Student;
import sms.pojo.Record.Type;
import sms.service.RecordService;
import sms.service.StudentService;

@WebServlet("/studentEdit.do")
public class StudentEditController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("-编辑学生-控制器-");
		super.service(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("studentId") != null && req.getSession().getAttribute("student") != null) {
			StudentService service = new StudentService();
			Student student = null;
			try {
				student = service.findStudentById(Integer.parseInt(req.getParameter("studentId")));
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
				resp.getWriter().println("Exception");
				return;
			}
			req.setAttribute("student", student);
			req.getRequestDispatcher("studentEdit.jsp").forward(req, resp);
		} else
			resp.getWriter().println("Login?");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student loginStudent = (Student) req.getSession().getAttribute("student");
		if (loginStudent != null) {

			String studentId = req.getParameter("studentId");
			String studentName = req.getParameter("studentName");
			String studentAccount = req.getParameter("studentAccount");
			String studentPwd = req.getParameter("studentPwd");

			// 数据封装
			int id = Integer.parseInt(studentId);
			Student student = new Student();
			student.setStudentId(id);
			student.setStudentName(studentName);
			student.setStudentAccount(studentAccount);
			student.setStudentPwd(studentPwd);

			// 将数据更新
			StudentService studentService = new StudentService();
			try {
				Student srcStudent = studentService.findStudentById(id);
				studentService.editStudent(student);

				StringBuilder recordBuilder = new StringBuilder();
				recordBuilder.append("ID:" + id);
				for (Field field : Student.class.getDeclaredFields()) {
					field.setAccessible(true);
					if (Objects.equals(field.get(srcStudent), field.get(student)) == false) {
						recordBuilder.append(" " + field.getName() + ":[" + field.get(srcStudent) + " -> "
								+ field.get(student) + "]");
					}
				}
				Record record = new Record(loginStudent.getStudentAccount(), Type.EDIT, recordBuilder.toString());
				RecordService recordService = new RecordService(req);
				recordService.addRecord(record);
			} catch (SQLException | IllegalAccessException e) {
				e.printStackTrace();
			}

			// 跳回到页面
			resp.sendRedirect(req.getContextPath() + "/studentList.do");
		}
	}
}
