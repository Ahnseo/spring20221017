package org.zerock.controller.lecture.p09fetch_or_ajax_or_xhr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ex46")
public class Controller46_thread_fetch_then {

	@RequestMapping("sub")
	public void method() {
		// forward void /ex46/sub.jsp
	}
	
	@GetMapping("sub01")
	@ResponseBody
	public String method1() throws InterruptedException {
		
		System.out.println("db 작업중... 좀 오래 걸리는 상황");
		
		Thread.sleep(5000);
		
		System.out.println("db 작업 끝");
		
		return "hello world!!!!!!!";

	}
}
