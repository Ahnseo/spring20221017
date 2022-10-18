package org.zerock.controller.lecture.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex10")
public class Controller10_Binding {
	
	//   /ex10/sub01?name=mikey
	@GetMapping(path="sub01", params = "name") //params = "name" 넣어야 아래 메소드와 분리시킬수있데..
	public void method1(@RequestParam("name") String name) {
		System.out.println(name);
	}
	//  /ex10/sub01
	@GetMapping("sub01")
	public void method1() {
		System.out.println("name 파라미터 없을때 일함");
	}
	
	//###바인딩 방법 : required = false 또는 defaultValue="???"#####################################
	// required = false : null 넘겨줌.
	//  /ex10/sub02?city=seoul, /ex10/sub02
	@GetMapping("sub02")
	public void method2(@RequestParam(name = "city", required = false) String c) {
		System.out.println("city = " + c );
		System.out.println("있어도~없어도~ 일함");
	}
	// /ex10/sub03?address=korea, /ex10/sub03
	@GetMapping("sub03")
	public void method3(@RequestParam(name="address", required = false) String ass) {
		System.out.println("address = " + ass);
		System.out.println("있어도~없어도~ 일함");
	}
	
	//defaultValue : 기본값 설정하고 싶을때
	// /ex10/sub04, /ex10/sub04?city=NewYork
	@GetMapping("sub04")
	public void method4(@RequestParam(name="city", defaultValue = "seoul") String c) {
		System.out.println(c);
	}
	// /ex10/sub05, /ex10/sub05?address=korea
	@GetMapping("sub05")
	public void method5(@RequestParam(name="address", defaultValue="seoul") String ass) {
		System.out.println("address = " + ass);
	}
}
