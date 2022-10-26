package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean05;
import org.zerock.domain.lecture.JavaBean06;
import org.zerock.mapper.lecture.Mapper03;

/** 순서는 상관없음.
 * ->mapper interface
 * ->xml
 * ->jdbc query
 * ->bean
 * ->controller (spring)
 * */
@Controller
@RequestMapping("ex30")
public class Controller30_manyColumn_oneRecord_xml_JavaBean_Map {
	//여러 컬럼과 여러 레코드 얻기
	
	@Autowired
	private Mapper03 mapper;
	//여러 컬럼과 여러 레코드 얻기
	@RequestMapping("sub01")
	public void method1() {
		JavaBean04 customer = mapper.getCustomer();
		System.out.println(customer);
	}
	//여러 컬럼과 여러 레코드 얻기
	@RequestMapping("sub02")
	public void method2() {
		JavaBean05 employee = mapper.getEmployee();
		System.out.println(employee);
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		/**
		 * SELECT FirstName, LastName
		 * FROM Employees
		 * WHERE EmployeeId = 5
		 * */
	}
	//xml파일 resultMap 생략함
	@RequestMapping("sub03")
	public void method3() {
		JavaBean05 employee2 = mapper.getEmployee2();
		System.out.println(employee2);
		System.out.println(employee2.getFirstName());
		System.out.println(employee2.getLastName());
	}
	//xml파일 별칭을 넣어 bean property를 맞춰서, resultMap 생략함
	@RequestMapping("sub04")
	public void method4() {
		JavaBean04 customer2 = mapper.getCustomer2();
		System.out.println(customer2);
		System.out.println(customer2.getName());
		System.out.println(customer2.getCountry());
	}
	//연습) xml alias(별칭)=bean property 
	//      -> resultMap 생략하기 
	@RequestMapping("sub05")
	public void method5() {
		JavaBean06 product = mapper.getProduct();
		System.out.println(product.getName());
		System.out.println(product.getPrice());
	}
	
}
