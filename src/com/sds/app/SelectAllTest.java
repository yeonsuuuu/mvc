package com.sds.app;

import java.util.ArrayList;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class SelectAllTest {

	public static void main(String[] args) {
		Service<String, CustomerVO> service =
				new CustomerService();
		
		ArrayList<CustomerVO> list = null;//만들어진 Arraylist를 줄거니까 new 할 필요 없당
		try {
			list = service.get();
			for(CustomerVO c: list) {
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
