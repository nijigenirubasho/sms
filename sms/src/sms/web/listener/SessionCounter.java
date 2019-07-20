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
		System.out.println("-���� session ���������ֵ������-");
		HttpSession session = event.getSession();
		Object user = session.getAttribute("student");
		if (user != null) {
			count++;
		}
		System.out.println(session);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("-session �������ֵ��ɾ��-");
		count--;
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("sesssion �������޸���");
	}

	public static int getCount() {
		return count;
	}
}
