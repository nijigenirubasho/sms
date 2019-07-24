package sms.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

	/**
	 * 插入记录
	 * 
	 * @param entity 参入实体类对象
	 * @return 返回的是数据库操作影响的行数
	 * @throws SQLException
	 */
	int insert(T entity) throws SQLException;

	/**
	 * 寻找所有记录
	 * @return
	 * @throws SQLException
	 */
	List<T> findAll() throws SQLException;

	/**
	 * 根据ID删除数据
	 * @param id
	 * @return 返回的是数据库操作影响的行数
	 * @throws SQLException
	 */
	int deleteById(Integer id) throws SQLException;
}
