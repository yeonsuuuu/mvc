package com.sds.frame;

public class SQL {
	public static String insertCustomer = 
			"INSERT INTO CUSTOMER VALUES (?,?,?)";//�ٷιٷ� String�� �����ϱ� ���� static ��
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
