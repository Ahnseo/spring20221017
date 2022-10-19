package org.zerock.controller.lecture.p03forward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex15")
public class Controller15_voidType {

	// /ex15/sub01
	@RequestMapping("sub01")
	public void method1() {
		System.out.println("메소드1 일함");
		// void type
		// @Controller 안에서, 아무일을 하지않아도 , ex15/sub01.jsp 로 포워드한다.
		// 검색결과 /WEB-INF/views/ex15/sub01.jsp
	}
	
	@RequestMapping("sub02")
	public void method2() {
		System.out.println("메소드2 일함!!");
		// void type, views 폴더에 ex15/sub02.jsp 파일을 만들겠음.
	}
	
	@RequestMapping("sub03")
	public String method3() {
		System.out.println("메소드3 일함!!!");
		//void 처럼, default view name을 사용해서 view로 포워드. 즉, URI 이름으로 view이름 으로 포워드 시도할 것 임.
		return null;
	}
	//연습) sub04요청, /WEB-INF/views/ex15/sub04.jsp
	@RequestMapping("sub04")
	public String method4() {
		System.out.println("메소드4 일함!!!!");
		return null;
	}
	//배운것종합연습) sub05요청, name request param 있으면, 
	// /WEB-INF/views/ex15/sub051.jsp 로 forward하고 
	// 없으면, /WEB-INF/views/ex15/sub05.jsp 로 forward하고 
	
	@RequestMapping("sub05")
	public String method5(String name) {
		if(name==null) {
			return null;
		}
		return "ex15/sub051";
	}
	// get 방식 sub06 요청
	// address request param 있으면,
	// /WEB-INF/views/ex15/sub061.jsp 로 forward
	//없으면, /WEB-INF/views/ex15/sub06.jsp forward
	@GetMapping("sub06")
	public String method6(@RequestParam ("address") String address) {
		if(address == null) {
			return null;
		}
		return "ex15/sub061";
	}
	
}
