package org.zerock.controller.lecture.p02param;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//springBean 때문에 클래스파일은 꼭 다른 이름으로 만들자.
//예시) 이름을 자세히 덧붙여서 만들자 
//      adminBoradController
//		clientBoradController

//참고 reference
//https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments

@Controller
@RequestMapping("ex08")
public class Controller08_HttpServletRequest {
	@GetMapping("sub01")
	public void method1() {
		System.out.println("method1@@@@@@@");
	}
	@GetMapping("sub02")
	public void method2( HttpServletRequest request) {
		System.out.println("method2");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(name);
		System.out.println(age);
	}
	//sub03 경로, get방식, HttpServletRequest 에 argument를 갖는 메소드 작성
	//address 파라미터 (쿼리스트링)
	//get parameter (address)꺼내서 출력코드 작성
	@GetMapping("sub03")
	public void method3(HttpServletRequest req) {
		String address = req.getParameter("address");
		System.out.println("address = " + address);
	}
	
}
