package org.zerock.controller.lecture.p09fetch_or_ajax_or_xhr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex42")
public class Controller42_produces_header_accept {
	
	@RequestMapping("sub")
	public void method() {
	
	}
	@GetMapping(path = "sub01", produces = "text/css")
	public void method1() {
		System.out.println("/ex42/sub01 메소드 일함");
		/**
		 * /ex42/sub01 의 Accept : text/plain 으로 되어있으니,
		 * @GetMapping(path = "sub01", produces = "text/css")의 메소드는 
		 * /ex42/sub01 페이지에서 실행되지 않음.
		 * */
	}
	
	@GetMapping(path = "sub02", produces = "text/html")
	public void method2() {
		System.out.println("/ex42/sub02 메소드 일함");
		/**
		 * /ex42/sub02 의 Accept : text/html 으로 되어있으니,
		 * @GetMapping(path = "sub01", produces = "text/html")의 메소드는 
		 * /ex42/sub02 페이지에서 실행 된다.
		 * */
	}
}
