package sms.web.ctrl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

@WebServlet(value = "/studentList.do")
public class StudentListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("-学生信息列表,控制器-");
		Student student = (Student) req.getSession().getAttribute("student");
		if (student != null) {
			StudentService studentService = new StudentService();
			try {
				List<Student> students = studentService.findAllStudent();
				req.setAttribute("students", students);

				Record record = new Record(student.getStudentAccount(), Type.QUERY, null);
				RecordService recordService = new RecordService(req);
				recordService.addRecord(record);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			req.getRequestDispatcher("/studentList.jsp").forward(req, resp);
		}
	}
}
