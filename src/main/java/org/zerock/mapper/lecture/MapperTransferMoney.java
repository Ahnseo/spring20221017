package org.zerock.mapper.lecture;

import org.zerock.domain.lecture.AccountsDAO;

public interface MapperTransferMoney {
	//int return 0,1
	
	AccountsDAO sendMoneyFromOtherAccount( int account, double money );
	AccountsDAO receiveMoneyFromOtherAccount( int account, double money );

}
