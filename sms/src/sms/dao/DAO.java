package sms.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

	/**
	 * �����¼
	 * 
	 * @param entity ����ʵ�������
	 * @return ���ص������ݿ����Ӱ�������
	 * @throws SQLException
	 */
	int insert(T entity) throws SQLException;

	/**
	 * Ѱ�����м�¼
	 * @return
	 * @throws SQLException
	 */
	List<T> findAll() throws SQLException;

	/**
	 * ����IDɾ������
	 * @param id
	 * @return ���ص������ݿ����Ӱ�������
	 * @throws SQLException
	 */
	int deleteById(Integer id) throws SQLException;
}
