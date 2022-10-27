package org.zerock.controller.lecture.p07mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.zerock.domain.lecture.JavaBean13;
import org.zerock.domain.lecture.JavaBean14;
import org.zerock.domain.lecture.JavaBean15;

import org.zerock.mapper.lecture.Mapper07;
import org.zerock.mapper.lecture.Mapper08;


@Controller
@RequestMapping("ex34") 
public class Controller34_xml_entity {
	
	@Autowired
	private Mapper07 mapper;
	@Autowired
	private Mapper08 mapper8;
	
	@RequestMapping("sub01")
	public void method1() {
		JavaBean13 category = mapper.getCategory();
		System.out.println("카테고리id: " + category.getId());
		System.out.println("카테고리명: " + category.getName());
		System.out.println("-- 상품들 --");
		category.getProducts().forEach(System.out::println);
	
	}
	
	@RequestMapping("sub02")
	public void method2() {
		JavaBean15 supplier = mapper.getSupplier();
		System.out.println(supplier.getId());
		System.out.println(supplier.getName());
		
		List<JavaBean14> product = supplier.getProducts();
		product.forEach(p -> {
			System.out.println(p.getId());
			System.out.println(p.getName());
			System.out.println(p.getPrice());
		});
	}
	/** 
	 * xml 에서 <, > 등의 기호를 사용할수없음.
	 * entity를  사용한다
	 * CDATA 를 사용한다
	 */ 
	@RequestMapping("sub03")
	public void method3() {
		mapper8.getProducts2().forEach(System.out::println);

	}
	
	@RequestMapping("sub04")
	public void method4() {
		mapper8.getEmployeeFirstName().forEach(System.out::println);
	}
	
	
}
