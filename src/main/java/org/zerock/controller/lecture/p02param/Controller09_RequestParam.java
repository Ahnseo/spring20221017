package org.zerock.controller.lecture.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex09")
public class Controller09_RequestParam {
	
	// request 수집, 가공하기
	
	
	//@RequestParam 바인딩(묶음)역할, 같은 name(또는value) 의 값들을 나열함
	//   /ex09/sub01?name=address
	@GetMapping("sub01")
	public void method1(@RequestParam (name="address") String a ) {
		System.out.println("address" + a);
	}
	//Get방식 sub02경로, RequestParam 으로 name을 받아서 , name 출력
	
	@GetMapping("sub02")
	public void method2(@RequestParam (name="name") String a) {
		System.out.println(a);
	}
	
	@GetMapping("sub03")
	public void method3(@RequestParam (value="name") String a) {
		System.out.println(a);
	}
	
	@GetMapping("sub04")
	public void method4(@RequestParam ("name") String a) { // 보통 이렇게 생략하고 사용한다.
		System.out.println("name" + a);
	}
	
	@GetMapping("sub05")
	public void method5(@RequestParam("name") String a,
						@RequestParam("address") String b){
		System.out.println("name" + a);
		System.out.println("address" + b);
	}
	//연습) /ex09/sub06?q=seoul&age=30
	@GetMapping("sub06")
	public void method6(@RequestParam("q") String a,
						@RequestParam("age") String b) {
		System.out.println("q = " + a);
		System.out.println("age = " + b);
	}
	//연습) /ex09/sub07?age=99
	@GetMapping("sub07")
	public void method7(@RequestParam("age") int a) {  //@RequestParam , 편리하게 int 형변환 해준다.
		System.out.println("age = " + a);
	}
	
	//연습) /ex09/sub08?num1=10&num2=20
	@GetMapping("sub08")
	public void method8(@RequestParam("num1") int a,
						@RequestParam("num2") int b) {
		System.out.println("num1 + num2 = " + (a + b) );
	}
	
	// request param -> method param 바인딩 될 때,
	// 자동 형변환 되는 type : String, 기본타입(primitive), wrapper(대문자타입들)
	// 연습) /ex09/sub09?a=str&b=2&c=4&d=3.14&e=5.55
	@GetMapping("sub09")
	private void method9(@RequestParam("a") String a,
						 @RequestParam("b") int b,
						 @RequestParam("c") Integer c,
						 @RequestParam("d") double d,
						 @RequestParam("e") Double e ) {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);

	}
	
}
