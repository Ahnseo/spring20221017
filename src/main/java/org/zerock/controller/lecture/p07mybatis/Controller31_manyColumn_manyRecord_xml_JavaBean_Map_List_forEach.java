package org.zerock.controller.lecture.p07mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean05;
import org.zerock.domain.lecture.JavaBean06;
import org.zerock.mapper.lecture.Mapper04;

@Controller
@RequestMapping("ex31")
public class Controller31_manyColumn_manyRecord_xml_JavaBean_Map_List_forEach {
	@Autowired
	private Mapper04 mapper;

	@RequestMapping("sub01")
	public void method1() {
		List<JavaBean06> productNamePrice = mapper.getProductNamePrices();
		System.out.println(productNamePrice.get(0));
		System.out.println(productNamePrice.get(1));
	}
	//연습) EmployeeList (firstname, lastname)
	@RequestMapping("sub02")
	public void method2() {
		List<JavaBean05> employList = mapper.getEmployeeList();
		System.out.println(employList.get(0).getFirstName());
		System.out.println(employList.get(0).getLastName());
		
		//람다식
		employList.forEach(System.out::println);
		
	}
	
	
}
