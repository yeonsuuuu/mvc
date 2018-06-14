package com.sds.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<T,V>{
	//service를 db에 sql로 요청받고 보내는 역할.	
	//여기서 변수 선언해주는 것은 되게 지양해야 한다.
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
	
	
	
	//abstract 함수들
	public abstract void insert(V v,Connection con) throws Exception; 
	public abstract void delete(T t,Connection con) throws Exception; 
	public abstract void update(V v,Connection con) throws Exception; 
	public abstract V select(T t,Connection con) throws Exception; //이렇게 하면 모든 타입을 수용할 수 있다.
	public abstract ArrayList<V> select(Connection con) throws Exception; //메서드 명이 똑같은 것을 보고 오버로딩이라 한다.. 이 경우엔 argument가 달라야 한다.


}
