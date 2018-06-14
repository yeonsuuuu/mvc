package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerDao extends Dao<String, CustomerVO> {

	@Override
	public void insert(CustomerVO v, Connection con) throws Exception {
		// Connection을 통해 PreparedStatement 생성
		// SQL 작성하여 DB 전송
		// Resource Close
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(SQL.insertCustomer);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getPwd());
			pstmt.setString(3, v.getName());
			pstmt.executeUpdate();
			close(pstmt);
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void delete(String t, Connection con) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CustomerVO v, Connection con) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public CustomerVO select(String t, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		CustomerVO customer = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(SQL.getCustomer);
			pstmt.setString(1, t);
			rs = pstmt.executeQuery();
			rs.next(); // 키값을 이동시킬 필요 있음
			customer = new CustomerVO(
					rs.getString("ID"),
					rs.getString("PWD"),
					rs.getString("NAME")
					);
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(rs);
		}
		return customer;
	}

	@Override
	public ArrayList<CustomerVO> select(Connection con) throws Exception {
		PreparedStatement pstmt = null;
		ArrayList<CustomerVO> customers = new ArrayList<>();
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(SQL.selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CustomerVO customer = null;
				customer = new CustomerVO(rs.getString("ID"),
						rs.getString("PWD"),
						rs.getString("NAME"));
				customer.setItem(new ItemVO(
						rs.getString("ID"),
						rs.getString("ITEMNAME"), 
						rs.getDouble("PRICE")));
				customers.add(customer);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
			close(rs);
		}
		return customers;
	}

}
