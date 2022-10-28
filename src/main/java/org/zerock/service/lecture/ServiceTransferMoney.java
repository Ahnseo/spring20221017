package org.zerock.service.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import org.zerock.mapper.lecture.MapperTransferMoney;

@Service
@Transactional
public class ServiceTransferMoney {
	
	@Autowired
	private MapperTransferMoney mapperTransferMoney;

	public void getTransferMoney(
								@RequestParam(name="account1") Integer account1,
								@RequestParam(name="money1") Double money1,
								@RequestParam(name="account2") Integer account2,
								@RequestParam(name="money2") Double money2
			) {
		
		mapperTransferMoney.sendMoneyFromOtherAccount(account1, money1);
		mapperTransferMoney.receiveMoneyFromOtherAccount(account2, money2);

	}
	
}
