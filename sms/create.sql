CREATE TABLE `tb_student` (
	`student_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'ѧ�����',
	`student_name` VARCHAR(50) NULL DEFAULT NULL COMMENT 'ѧ����',
	`student_account` VARCHAR(50) NULL DEFAULT NULL COMMENT 'ѧ���˺�',
	`student_pwd` VARCHAR(50) NULL DEFAULT NULL COMMENT 'ѧ����¼����',
	PRIMARY KEY (`student_id`),
	UNIQUE `student_name` (`student_name`)
) COLLATE = 'utf8_general_ci' ENGINE = InnoDB;