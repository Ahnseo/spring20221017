package org.zerock.controller.lecture.p04attribute;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex16")
public class Controller16_AddAttribute {
	//1.요청받고
	//2.request param 수집 
	//3.request param 가공
	//4.business logic
	//5.add attribute
	//6.forward / redirect
	
	//add attribute 방법
	
	// /ex16/sub01 요청할떄,실행되고
	// /WEB-INF/views/ex16/sub01.jsp 로 포워드함	
	@RequestMapping("sub01")
	public void method1(HttpServletRequest req) {
		req.setAttribute("myName", "Ahnseojung");
	}
	
	@RequestMapping("sub02")
	public void method2(HttpServletRequest request) {
		request.setAttribute("address", "seoul");
	}
}
