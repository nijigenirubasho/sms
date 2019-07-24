package sms.web.ctrl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/")
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.err.println("!!!WELCOME TO STUDENT MANAGEMENT SYSTEM!!!");
		System.out.println("--入口：studentLogin.jsp--");
		// resp.sendError(451, "走错门了");
		resp.sendRedirect(req.getContextPath() + "/studentLogin.jsp");
	}
}
