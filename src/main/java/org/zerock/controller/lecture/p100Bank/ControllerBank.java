package org.zerock.controller.lecture.p100Bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.service.lecture.ServiceTransferMoney;

@Controller
@RequestMapping("/sample")
public class ControllerBank {
	
	//ctrl -> service -> mapper -> xml 
	@Autowired
	ServiceTransferMoney serviceTransferMoney;
	
	// sample/bankServie?account1=1&money1=1000&account2=1&money2=1000
	// Bean을 제대로 사용 못한것같아. 다음에 다시해보자.
	@RequestMapping("bankServie")
	public void transferMoney(
			@RequestParam(name="account1") Integer account1,
			@RequestParam(name="money1") Double money1,
			@RequestParam(name="account2") Integer account2,
			@RequestParam(name="money2") Double money2
			) {
		serviceTransferMoney.getTransferMoney(account1,money1,account2,money2);

	}
}
