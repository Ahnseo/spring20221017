package org.zerock.controller.lecture.p07mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean16;
import org.zerock.domain.lecture.JavaBean17;
import org.zerock.mapper.lecture.Mapper09;

@Controller
@RequestMapping("ex35")
public class Controller35_xml_how_to_pstmt {

	@Autowired
	private Mapper09 mapper9;
	
	@RequestMapping("sub01")
	public void method1() {
		String name1 = mapper9.getCusmtomerNameById(1);
		String name2 = mapper9.getCusmtomerNameById(2);
		
		System.out.println(name1);
		System.out.println(name2);
	}
	
	@RequestMapping("sub02")
	public void method2() {
		String name1 = mapper9.getEmployeeFirstNameById(1);
		String name2 = mapper9.getEmployeeFirstNameById(2);
		System.out.println(name1);
		System.out.println(name2);
	}
	
	@RequestMapping("sub03")
	public void method3() {
		List<String> london = mapper9.getCustomerNameByCityAndCountry("London", "UK");
		london.forEach(i->System.out.println(i));
	}
	@RequestMapping("sub04")
	public void method4() {
		String londona = mapper9.getSupplierNameByCityAndCountry("UK", "Londona");
		String newOrl = mapper9.getSupplierNameByCityAndCountry("USA", "New Orleans");
		System.out.println(londona);
		System.out.println(newOrl);
	}
	// /ex35/sub05?name=Alfreds Futterkiste&country=Germany
	// ---> Maria Anders
	// /ex35/sub05?name=Antonio Moreno Taquería&country=Mexico
	// ---> Antonio Moreno
	@RequestMapping("sub05")
	                  //@Modelattribute()
	public void method5(JavaBean04 p) {
		String name1 = mapper9.getContactName(p);
		System.out.println(name1);
	}
	// /ex35/sub06?name=New Orleans Cajun Delights&country=USA
	// ---> Shelley Burke
	
	// /ex35/sub06?name=Grandma Kelly's Homestead&country=USA
	// ---> Regina Murphy
	@RequestMapping("sub06")
	public void method6(JavaBean04 b) {
		String name1 = mapper9.getSupplierContactName(b);
		System.out.println(name1);
	}
	
	// ex35/sub07?categoryId=1&price=20.00
	// ex35/sub07?categoryId=2&price=30.00
	@RequestMapping("sub07")
	public void method7(JavaBean16 param1, JavaBean17 param2) {
		List<String> list = mapper9.getNameByCategoryPrice(param1, param2);
				list.forEach(System.out::println);
	}
	
	
}
