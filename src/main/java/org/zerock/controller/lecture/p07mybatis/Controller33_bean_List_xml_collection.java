package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.BuyProducts;
import org.zerock.domain.lecture.JavaBean11;
import org.zerock.domain.lecture.JavaBean12;
import org.zerock.mapper.lecture.Mapper06;

@Controller
@RequestMapping("ex33")
public class Controller33_bean_List_xml_collection {

	@Autowired
	private Mapper06 mapper;
	
	//1개의 카테고리id 안에 속하는 상품명들~
	@RequestMapping("sub01")
	public void method1() {
		JavaBean11 category = mapper.getCategory();
		
		System.out.println(category.getId());
		System.out.println(category.getName());
		category.getProductName().forEach(System.out::println);
	}
	
	//한 명의 공급자가 관리하는상품명들~
	@RequestMapping("sub02")
	public void method2() {
		JavaBean12 supplier = mapper.getSupplierProduct();
		
		System.out.println("공급자ID: " + supplier.getId());
		System.out.println("공급자명: " + supplier.getName());
		System.out.println("--- 상품명 ---");
		supplier.getProductName().forEach(System.out::println);
	}
	
	//한 명이 주문한 상품들 나열하기
	//CustomerId =1 인 사람은 몇번 주문했을까?
	@RequestMapping("sub03")
	public void method3() {
		BuyProducts person1 = mapper.getBuyProducts();
		
		System.err.println("고객id: " + person1.getId());
		System.out.println("고객이름: " + person1.getName());
		System.out.println("-- 주문번호들 --");
		person1.getOrderIds().forEach( (e) -> System.out.println(e) );

	}
	
}
