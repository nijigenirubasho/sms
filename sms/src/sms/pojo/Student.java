package sms.pojo;

public class Student {

	// 用Integer而不用int的原因：数据可空
	private Integer studentId;// INT(11) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
	private String studentName;// VARCHAR(50) NULL DEFAULT NULL COMMENT '学生名',
	private String studentAccount;// VARCHAR(50) NULL DEFAULT NULL COMMENT '学生账号',
	private String studentPwd;// VARCHAR(50) NULL DEFAULT NULL COMMENT '学生登录密码',

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAccount() {
		return studentAccount;
	}

	public void setStudentAccount(String studentAccount) {
		this.studentAccount = studentAccount;
	}

	public String getStudentPwd() {
		return studentPwd;
	}

	public void setStudentPwd(String studentPwd) {
		this.studentPwd = studentPwd;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAccount=" + studentAccount
				+ ", studentPwd=" + studentPwd + "]";
	}
	
}
