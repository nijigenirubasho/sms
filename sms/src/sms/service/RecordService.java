package sms.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sms.dao.impl.RecordDAO;
import sms.pojo.Record;

public class RecordService {

	private HttpServletRequest request;

	public RecordService(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * ��Ӽ�¼
	 * 
	 * @param record
	 * @return ���ؼ�¼�б��ȣ�ʧ�ܷ���-1
	 */
	public int addRecord(Record record) {
		RecordDAO dao = new RecordDAO(request.getServletContext());
		try {
			return dao.insert(record);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public List<Record> findAllRecord() {
		RecordDAO dao = new RecordDAO(request.getServletContext());
		try {
			return dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
