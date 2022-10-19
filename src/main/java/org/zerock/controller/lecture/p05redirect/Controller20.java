package org.zerock.controller.lecture.p05redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex20")
public class Controller20 {
	// redirect 일때, 데이터 넘겨주는 방법
	
	//1. query string으로 붙여서 넘겨주기
	@RequestMapping("sub01")
	public String method1() {
		return "redirect:/ex20/sub02?name=donald"; //이 페이지로 다시 응답해라
	}
	@RequestMapping("sub02")
	public String method2(String name) {
		System.out.println("리다이렉트 sub02 잘됨");
		System.out.println(name);
		return null; //void type 역할
	}
	
	//연습) 쿼리스트링을 귀찮게 작성하여, redirect 과정을 연습 중..
	//      쿼리스트링의 한계 : String 으로 만 보낼수있음.
	//      session으로 해결가능 
	@RequestMapping("sub03")
	public String method3() {
		// ex20/sub04?address=seoul&age=33
		return "redirect:/ex20/sub04?address=seoul&age=33";
	}
	@RequestMapping("sub04")      
	public void method3(String address, int age) {
		
		System.out.println(address);
		System.out.println(age);
	}
	
}
