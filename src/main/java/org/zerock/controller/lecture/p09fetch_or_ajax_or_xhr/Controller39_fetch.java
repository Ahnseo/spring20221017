package org.zerock.controller.lecture.p09fetch_or_ajax_or_xhr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex39")
public class Controller39_fetch {
	
	@RequestMapping("sub01")
	public void method1() {
		// TODO Auto-generated method stub

	}
	@RequestMapping("sub02")
	public void method2() {
		// TODO Auto-generated method stub
		
	}
	@RequestMapping("sub03")
	public void method3() {
		System.out.println("버튼3 /ex39/sub03 요청 받음");

	}	
}
