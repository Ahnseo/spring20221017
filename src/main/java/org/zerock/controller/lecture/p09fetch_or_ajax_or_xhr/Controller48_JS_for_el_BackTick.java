package org.zerock.controller.lecture.p09fetch_or_ajax_or_xhr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;
import org.zerock.mapper.lecture.Mapper11;

@Controller
@RequestMapping("ex48")
public class Controller48_JS_for_el_BackTick {
	
	@Autowired
	private Mapper11 mapper;
	
	@RequestMapping("sub")
	public void method() {
		//포워드 sub.jsp
	}
	
	@GetMapping("sub01")
	@ResponseBody
	public List<JavaBean18> method1() {
		List<JavaBean18> customers = mapper.getCustomersList();
		
		return customers;
	}
	
	@GetMapping("sub02")
	@ResponseBody
	public List<JavaBean19> method2() {
		List<JavaBean19> suppliers = mapper.getSuppliersList();
		
		return suppliers;
	}
	
}
