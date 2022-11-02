package org.zerock.controller.lecture.p09fetch_or_ajax_or_xhr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex43")
public class Controller43_getData_from_client {
	
	//브라우저에서 -> 서버로 요청 하기. 를 배우고 있다.
	//클라이언트가 요청하고 싶은 값들을 Controller에 전송!
	//                                  ( @GetMapping, @PostMapping, @PutMapping, @DeleteMapping 으로 전송 됨  )
	@RequestMapping("sub")
	public void method() {
		//void 포워드 sub.jsp
	}
	
	@GetMapping(path = "sub01")
	public void method1(String name, String address) {
		System.out.println("/ex42/sub01 get방식 요청");
		System.out.println(name);
		System.out.println(address);

	}
	@GetMapping("sub02")
	public void method2(String email, Integer age) {
		System.out.println(email);
		System.out.println(age);
	}
	
	@GetMapping("sub03")
	public void method3(String name, String email) {
		System.out.println(name);
		System.out.println(email);
	}
	
	@GetMapping("sub04")
	public void method4(String address, Integer age) {
		System.out.println(address);
		System.out.println(age);
	}
	
	@PostMapping("sub05")
	public void method5(String address, Integer age) {
		System.out.println("sub05일함");
		System.out.println(address);
		System.out.println(age);

	}
	
	@PostMapping("sub06")
	public void method6(String name, String email) {
		System.out.println("6번 메소드 일함");
		System.out.println(name); // null 아니게
		System.out.println(email); // null 아니게
	}
	
	@PostMapping("sub07")
	public void method7(String name, String email) {
		System.out.println("7번 메소드 일함");
		System.out.println(name);
		System.out.println(email);
		
	}
	@PostMapping("sub08")
	public void method8(String address, Integer age) {
		System.out.println("8번 메소드 일함");
		System.out.println(address); // null 아니게
		System.out.println(age); // null 아니게
	}
	
	
}
