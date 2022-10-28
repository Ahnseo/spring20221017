package org.zerock.controller.lecture.p08mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.lecture.Service01;

@Controller
@RequestMapping("ex38")
public class Contoller38_Bank {
	@Autowired
	private Service01 service;
	
	
	@RequestMapping("sub01")
	public void method1(){
		//request 파라미터 수집 가공
		
		//비지니스 로직 처림
		//mapper.getCustomer(); xxx
		
		int id =5;
		//service.getCustomer(id);
		
		// add attribute
		//포워드 /리다이렉트
	}
	
	// ###간단한 은행 업무, Service *Transactional*
	// controller -> service -> mapper
	@RequestMapping("sub02")
	public void method2() {
		// 리퀘스트 파람 수집 가공
		
		//비지니스 로직
		service.tranferMoney();
		
		//모델추가
		//포워드/ 리다이렉트
	}
	
	
	
}
