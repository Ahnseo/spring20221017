package org.zerock.service.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.mapper.lecture.Mapper11;

@Service
@Transactional //특별한일이 없으면, service 클래스 위에.
// *Service는 인터페이스*로 만들고 ,그 안에 클래스로 비지니스 로직을 만든다.
// 이유는 수많은 업무 수정으로 ,클래스 이름이 바뀌거나 하기때문에, 
// 컨트롤러와 밀접하게 연결된 Service 파일명이 바뀌는것에 오류를 방지하기위해서

public class Service01 {
	
	@Autowired
	private Mapper11 mapper;

	public JavaBean18 getCustomer(int id) {
		// 비지니스 로직
		return mapper.getCustomerById(id);
	}
	
	@Transactional
	public void tranferMoney() {
		// 1번 고객의 돈을 500원씩 2번 고객에게 전달
		// 스프링 transaction 처리는 -> root-context.xml 으로 설정
		//mapper.updateBank(1, -500);
		//mapper.updateBank(2, +500);
	}
	
}
