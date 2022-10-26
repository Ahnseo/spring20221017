package org.zerock.controller.lecture.p07mybatis;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.zerock.mapper.lecture.Mapper02;

@Controller
@RequestMapping("ex29")
public class Controller29_oneColumn_manyRecords_xml_List {
	
	@Autowired
	private Mapper02 mapper;
// 컬럼 1개 , 레코드 여러개 일 경우 : List 사용	
	@RequestMapping("sub01")
	public void method1() {
		List<String> names = mapper.getCustomerNames();
		
		System.out.println(names.size());
		
		for(int i = 1; i< names.size(); i++) {
			System.out.println(names.get(i));
		}
	}
	
	@RequestMapping("sub02")
	public void method2() {
		List<Integer> Ids = mapper.getCustomerIds();
		System.out.println(Ids.size());
	}
	
	@RequestMapping("sub03")
	public void method3() {
		List<Double> priceList = mapper.getProductPrices();
		System.out.println(priceList.size());
		System.out.println(priceList.get(0));
		System.out.println(priceList.get(1));
	}
	
	@RequestMapping("sub04")
	public void method4() {
		List<java.time.LocalDate> birthDateList = mapper.getBirthDates();
		
		System.out.println(birthDateList.size());

		birthDateList.forEach(System.out::println); // 오랜만에 람다식
		
	}
}









