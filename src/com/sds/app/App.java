package com.sds.app;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class App {

	public static void main(String[] args) {
		Service<String,CustomerVO> service = 
				new CustomerService();
		CustomerVO customer = 
				new CustomerVO("id11","pw11","������");
		try {
			service.register(customer);//service�� register��� �Լ����� ȣ���Ѵ�
			System.out.println("�Է� ����");
		} catch (Exception e) {
			System.out.println("�Է� ����");
		}
	}

}
