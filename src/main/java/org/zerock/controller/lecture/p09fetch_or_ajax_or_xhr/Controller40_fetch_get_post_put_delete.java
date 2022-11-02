package org.zerock.controller.lecture.p09fetch_or_ajax_or_xhr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("ex40")
public class Controller40_fetch_get_post_put_delete {
	
	//sub0.jsp(하나의 페이지)에 여러 fetch 만들어서 다른 jsp(다른 페이지)를 ajax한다.
	//  여러 페이지 -> 하나의 페이지에 Asyncronize 
	@RequestMapping("sub0")
	public void method1() {
		//sub0.jsp 포워드void
		//웹페이지 F12 소스 확인
	}	
	@GetMapping("sub01")
	public void method2() {
		System.out.println("/ex40/sub01 get방식 요청을 잘 받음");
	}
	@GetMapping("sub02")
	public void method3() {
		System.out.println("/ex40/sub02 get방식 요청을 잘 받음!!");
	}
	@PostMapping("sub03")
	public void method4() {
		System.out.println("/ex40/sub03 post방식 요청을 잘 받음!!!");
	
	}
	//연습
	@GetMapping("sub04")
	public void method5() {
		System.out.println("/ex40/sub04 get방식 요청을 잘 받음$$$");
	}
	@PostMapping("sub04")
	public void method6() {
		System.out.println("/ex40/sub04 post방식 요청을 잘 받음###");
	}
	
	//@RequestMapping(path = "sub04", method = RequestMethod.PUT)
	@PutMapping("sub04")
	public void method7() {
		System.out.println("/ex40/sub04 PUT방식 요청을 잘 받음");
	}
	//@RequestMapping(path = "sub04", method = RequestMethod.DELETE)
	@DeleteMapping("sub04")
	public void method8() {
		System.out.println("/ex40/sub04 Delete방식 요청을 잘 받음");
	}
	
	//연습
	@GetMapping("sub05")
	public void method9() {
		System.out.println("/ex40/sub05 get방식 요청을 잘 받음");
	}
	@PostMapping("sub05")
	public void method10() {
		System.out.println("/ex40/sub05 post방식 요청을 잘 받음");
	}
	@PutMapping("sub05")
	public void method11() {
		System.out.println("/ex40/sub05 put방식 요청을 잘 받음");
	}
	@DeleteMapping("sub05")
	public void method12() {
		System.out.println("/ex40/sub05 delete방식 요청을 잘 받음");
	}

}
