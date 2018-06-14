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
		// 고객 정보가 들어오면
		// 고객 정보에 아이템을 셋팅하고
		// Dao를 통해 저장 요청을 한다.
		ItemVO item = new ItemVO("id01", "칼", 1000);
		Connection con = getConn();
		try {
			cDao.insert(v, con);// 첫번째 고객정보 들어감
			iDao.insert(item, con);
			con.commit();// 정상이면 커밋하구
			// close(con);//닫아줘야함
		} catch (Exception e) {
			con.rollback();// 문제가 발생하면 롤백을 시키고
			throw e;
		} finally {
			close(con);// 예외발생하면 close안되니까 finally에서 달아줌
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

}//서비스에서는 기능구현
