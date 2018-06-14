package com.sds.app;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class App {

	public static void main(String[] args) {
		Service<String,CustomerVO> service = 
				new CustomerService();
		CustomerVO customer = 
				new CustomerVO("id11","pw11","정말숙");
		try {
			service.register(customer);//service의 register라는 함수에게 호출한당
			System.out.println("입력 정상");
		} catch (Exception e) {
			System.out.println("입력 실패");
		}
	}

}
