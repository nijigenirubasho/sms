package sms.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionCounter implements HttpSessionAttributeListener {

	private static int count;

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("-监听 session 的作用域的值被增加-");
		HttpSession session = event.getSession();
		Object user = session.getAttribute("student");
		if (user != null) {
			count++;
		}
		System.out.println(session);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("-session 作用域的值被删除-");
		count--;
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("sesssion 作用域被修改了");
	}

	public static int getCount() {
		return count;
	}
}
