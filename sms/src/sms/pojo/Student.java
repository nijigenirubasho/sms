package sms.pojo;

public class Student {

	// ��Integer������int��ԭ�����ݿɿ�
	private Integer studentId;// INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ѧ�����',
	private String studentName;// VARCHAR(50) NULL DEFAULT NULL COMMENT 'ѧ����',
	private String studentAccount;// VARCHAR(50) NULL DEFAULT NULL COMMENT 'ѧ���˺�',
	private String studentPwd;// VARCHAR(50) NULL DEFAULT NULL COMMENT 'ѧ����¼����',

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
