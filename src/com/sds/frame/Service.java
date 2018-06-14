package com.sds.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Service<T,V> {
	private String id = "db";
	private String password = "db";
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	//뼈대. dao보다 얘를 먼저 만든다.
	//jdbc driver을 메모리에 올리자.
	public Service() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() throws SQLException{
		Connection con = null;
		con = DriverManager.getConnection(url, id, password);
		con.setAutoCommit(false);
		return con;
	}
	
	
	public void close(Connection con) throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
	
	public abstract void register(V v) throws Exception; 
	public abstract void remove(T t) throws Exception; 
	public abstract void modify(V v) throws Exception; 
	public abstract V get(T t) throws Exception; //이렇게 하면 모든 타입을 수용할 수 있다.
	public abstract ArrayList<V> get() throws Exception; //메서드 명이 똑같은 것을 보고 오버로딩이라 한다.. 이 경우엔 argument가 달라야 한다.

}
