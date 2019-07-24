package sms.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import sms.dao.DAO;
import sms.pojo.Record;

@SuppressWarnings("unchecked")
public class RecordDAO implements DAO<Record> {

	private ServletContext context;

	public RecordDAO(ServletContext context) {
		this.context = context;
	}

	@Override
	public int insert(Record entity) throws SQLException {
		List<Record> opList = (List<Record>) context.getAttribute("op_record");
		if (opList == null)
			opList = new ArrayList<>();
		opList.add(entity);
		context.setAttribute("op_record", opList);
		return opList.size();
	}

	@Override
	public List<Record> findAll() throws SQLException {
		return (List<Record>) context.getAttribute("op_record");
	}

	@Override
	public int deleteById(Integer id) throws SQLException {
		throw new SQLException("不能删除操作记录");
	}
}
