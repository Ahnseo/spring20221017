package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean08;
import org.zerock.domain.lecture.JavaBean09;

import org.zerock.mapper.lecture.Mapper05;

@Controller
@RequestMapping("ex32")
public class Controller32_xml_association {
	
	@Autowired
	private Mapper05 mapper;
	
	@RequestMapping("sub02")
	public void method2() {
		
		JavaBean08 OrderList2 = mapper.getOrder2();
		
		System.out.println(OrderList2.getId());
		System.out.println(OrderList2.getDate());
		System.out.println(OrderList2.getEmployee().getEmployeeId());
		System.out.println(OrderList2.getEmployee().getFirstName());
		System.out.println(OrderList2.getEmployee().getLastName());
	}
	
	@RequestMapping("sub03")
	public void method3(){
		JavaBean09 ProductInfo = mapper.getProduct();
	
//		System.out.println(ProductInfo);
		System.out.println(ProductInfo.getId());
		System.out.println(ProductInfo.getName());
		System.out.println(ProductInfo.getPrice());
		System.out.println(ProductInfo.getSupplier().getId());;
		System.out.println(ProductInfo.getSupplier().getName());
		System.out.println(ProductInfo.getSupplier().getPhone());
	}

}
