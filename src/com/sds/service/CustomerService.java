package com.sds.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.sds.dao.CustomerDao;
import com.sds.dao.ItemDao;
import com.sds.frame.Dao;
import com.sds.frame.Service;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerService extends Service<String, CustomerVO> {

	Dao<String, CustomerVO> cDao;
	Dao<String, ItemVO> iDao;

	public CustomerService() {
		cDao = new CustomerDao();
		iDao = new ItemDao();
	}

	@Override
	public void register(CustomerVO v) throws Exception {
		// �� ������ ������
		// �� ������ �������� �����ϰ�
		// Dao�� ���� ���� ��û�� �Ѵ�.
		ItemVO item = new ItemVO("id01", "Į", 1000);
		Connection con = getConn();
		try {
			cDao.insert(v, con);// ù��° ������ ��
			iDao.insert(item, con);
			con.commit();// �����̸� Ŀ���ϱ�
			// close(con);//�ݾ������
		} catch (Exception e) {
			con.rollback();// ������ �߻��ϸ� �ѹ��� ��Ű��
			throw e;
		} finally {
			close(con);// ���ܹ߻��ϸ� close�ȵǴϱ� finally���� �޾���
		}
	}

	@Override
	public void remove(String t) throws Exception {

		Connection con = getConn();
		try {
			cDao.delete(t, con);
			iDao.delete(t, con);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		} finally {
			close(con);
		}

	}

	@Override
	public void modify(CustomerVO v) throws Exception {

	}

	@Override
	public CustomerVO get(String t) throws Exception {
		CustomerVO customer = null;
		Connection con = getConn();
		try {
			customer = cDao.select(t, con);
			customer.setItem(iDao.select(t, con));
		} catch (Exception e) {
			throw e;
		} finally {
			close(con);
		}
		return customer;
	}

	@Override
	public ArrayList<CustomerVO> get() throws Exception {
		ArrayList<CustomerVO> customers = null;
		Connection con = getConn();
		try {
			customers = cDao.select(con);
		} catch (Exception e) {
			throw e;
		} finally {
			close(con);
		}
		return customers;
	}

}//���񽺿����� ��ɱ���
