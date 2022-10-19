package org.zerock.controller.lecture.p03forward;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("ex14")
public class Controller14_StringType {
	//1.요청받고
	//2.request param 수집 
	//3.request param 가공
	//4.business logic
	//5.add attribute
	//6.forward / redirect
	
	//이전의 스프링 배우지 않았을때, 포워드방식은..
	public void method1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path ="/WEB-INF/views/ex14/view14.jsp"; 
		request.getRequestDispatcher(path).forward(request, response);
	}// 이렇게 긴 코드였는데,
	
    //스프링 포워드를 사용하면, HttpServlet request, response를 관리하지 않아도 된다
	//즉, @Controller 안에서, 메소드가 String type 이면 return view 이름이다.
	//                                   void type 이면 return  URI 이름이 view이름이 된다.
	@RequestMapping("sub02")
	public String method2() {
		System.out.println("method2 일함!!!");
		//abc.jsp 파일은 없지만, 이렇게 적용한다.
		return "abc"; //servlet-context.xml에 의해 포워드 를 이렇게 jsp파일 이름만 넣어서 가능하다.
	}
	
	//연습) /ex14/sub03
	@RequestMapping("sub03")
	public String method3() {
		System.out.println("method3 일함!!!!!");
		return "view14";
	}
	
	//연습) /ex14/sub04 
	@RequestMapping("sub04")
	public String method4() {
	//  /WEB-INF/views/ex14/sub04	
		return "ex14/sub04";
	}
	//연습) /ex14/sub05  , 일도 하고, 포워드도 하고
	@RequestMapping("sub05")
	public String method5() {
		System.out.println("method5 일함###");
		return "ex14/sub05";
	}
	
}
