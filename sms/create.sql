CREATE TABLE `tb_student` (
	`student_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '学生编号',
	`student_name` VARCHAR(50) NULL DEFAULT NULL COMMENT '学生名',
	`student_account` VARCHAR(50) NULL DEFAULT NULL COMMENT '学生账号',
	`student_pwd` VARCHAR(50) NULL DEFAULT NULL COMMENT '学生登录密码',
	PRIMARY KEY (`student_id`),
	UNIQUE `student_name` (`student_name`)
) COLLATE = 'utf8_general_ci' ENGINE = InnoDB;