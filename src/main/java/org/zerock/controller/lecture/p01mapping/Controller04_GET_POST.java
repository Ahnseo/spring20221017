package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ex04")
public class Controller04_GET_POST {
	
	@RequestMapping("sub01")
	public void method1() {
	
		System.out.println("메소드1 일함");
	}
	@RequestMapping(value = "sub02", method = RequestMethod.GET)
	public void method2() {
		
		System.out.println("GET메소드2 일함");
	}
	
	@RequestMapping(value = "sub02", method = RequestMethod.POST)
	public void method3() {
		
		System.out.println("POST메소드3 일함");
	}
	
	@RequestMapping(
			value = "sub03",
			method = { RequestMethod.GET, RequestMethod.POST})
	public void method4() {
		
		System.out.println("GET & POST 메소드4 일함");
	}
	
	//
	@RequestMapping(
			value = "sub04",
			method = { RequestMethod.GET, RequestMethod.POST})
		public void method5() {
		
		System.out.println("GET & POST 메소드5 일함");
	}

}
