package com.sds.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<T,V>{
	//service�� db�� sql�� ��û�ް� ������ ����.	
	//���⼭ ���� �������ִ� ���� �ǰ� �����ؾ� �Ѵ�.
	public void close(ResultSet rset) throws SQLException {
		if(rset!=null) {
			rset.close();
		}
	}
	
	public void close(PreparedStatement pstmt) throws SQLException {
		if(pstmt!=null) {
			pstmt.close();
		}
	}
	
	
	
	//abstract �Լ���
	public abstract void insert(V v,Connection con) throws Exception; 
	public abstract void delete(T t,Connection con) throws Exception; 
	public abstract void update(V v,Connection con) throws Exception; 
	public abstract V select(T t,Connection con) throws Exception; //�̷��� �ϸ� ��� Ÿ���� ������ �� �ִ�.
	public abstract ArrayList<V> select(Connection con) throws Exception; //�޼��� ���� �Ȱ��� ���� ���� �����ε��̶� �Ѵ�.. �� ��쿣 argument�� �޶�� �Ѵ�.


}
