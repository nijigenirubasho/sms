package sms.pojo;

import java.time.LocalDateTime;

public class Record {

	public Record(String studentAccount, Type type, String parameter) {
		this.time = LocalDateTime.now();
		this.studentAccount = studentAccount;
		this.type = type;
		this.parameter = parameter;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public String getStudentAccount() {
		return studentAccount;
	}

	public Type getType() {
		return type;
	}

	public String getParameter() {
		return parameter;
	}

	private LocalDateTime time;
	private String studentAccount;
	private Type type;
	private String parameter;

	public enum Type {
		ADD, DELETE, EDIT, QUERY
	}
}
