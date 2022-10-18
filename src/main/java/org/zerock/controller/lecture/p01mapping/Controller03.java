package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex03")
public class Controller03 {

	// /ex03/sub01
	// /ex03/sub02
	// /ex03/sub03
	@RequestMapping({"sub01", "sub02", "sub03"})
	public void method1() {
		System.out.println("ex03 method1");
	}
	
	// /ex03/sub04
	// /ex03/sub05
	@RequestMapping({"sub04","sub05"})
	public void method2() {
		System.out.println("ex03 method2");

	}
	
	@RequestMapping(value = "sub06")
	public void method3() {
		System.out.println("method3 일함");
	}
	@RequestMapping( path = "sub07")
	public void method4() {
		System.out.println("method4 일함");
	}
}





