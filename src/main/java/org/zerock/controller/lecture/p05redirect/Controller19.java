package org.zerock.controller.lecture.p05redirect;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex19")
public class Controller19 {
	@RequestMapping("sub01")
	public void method1(HttpServletResponse response) throws IOException {
		//redirect response : 다른곳으로 가라는 응답
		String location = "sub02";
		response.sendRedirect(location);
	}
	
	@RequestMapping("sub03")
	public String method2() {
		return "redirect:sub04"; // 클라이언트가 사용하는 경로임
	}
	//sub05 요청 -> sub06 redirect
	@RequestMapping("sub05")
	public String method3() {
		return "redirect:sub06"; //클라이언트가 사용하는 경로임

	}
	//이전의 방법
		@RequestMapping("sub07")
		public void method4(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String location = request.getContextPath() + "/ex19/sub08";
			response.sendRedirect(location);
		}
	//스프링 리다이렉트 방법
		@RequestMapping("sub11")
		public String method6() {
			//         ** 첫 / 가 'contextPath' 역할을 함***
			return "redirect:/ex19/sub12";

		}
	
}
