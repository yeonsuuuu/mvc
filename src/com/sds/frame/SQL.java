package com.sds.frame;

public class SQL {
	public static String insertCustomer = 
			"INSERT INTO CUSTOMER VALUES (?,?,?)";//바로바로 String에 접근하기 위해 static 씀
	public static String insertItem = 
			"INSERT INTO USERITEM VALUES (?,?,?)";
	public static String getCustomer = 
			"SELECT * FROM CUSTOMER WHERE ID = ?";
	public static String getItem = 
			"SELECT * FROM USERITEM WHERE ";
	public static String selectAll = 
			"SELECT C.ID, C.PWD, C.NAME, U.NAME AS ITEMNAME, U.PRICE FROM CUSTOMER C, USERITEM U WHERE C.ID = U.ID";
	public static String selectAllItem = 
			"SELECT * FROM USERITEM";
}
