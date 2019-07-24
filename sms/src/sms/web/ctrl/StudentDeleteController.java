package sms.web.ctrl;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sms.pojo.Record;
import sms.pojo.Record.Type;
import sms.pojo.Student;
import sms.service.RecordService;
import sms.service.StudentService;

@WebServlet(value = "/studentDelete.do")
public class StudentDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("student") != null)
			doPost(req, resp);
		else
			resp.sendRedirect(req.getContextPath() + "/studentLogin.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("-删除学生-控制器-");
		String studentId = req.getParameter("studentId");
		System.out.println("学生编号:" + studentId);
		StudentService studentService = new StudentService();
		try {
			Integer id = Integer.valueOf(studentId);
			Student deleteStudent = studentService.findStudentById(id);
			studentService.deleteStudentById(id);

			if (deleteStudent != null) {
				Student loginStudent = (Student) req.getSession().getAttribute("student");
				Record record = new Record(loginStudent.getStudentAccount(), Type.DELETE, deleteStudent.toString());
				RecordService recordService = new RecordService(req);
				recordService.addRecord(record);
			}
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect(req.getContextPath() + "/studentList.do");
	}
}
