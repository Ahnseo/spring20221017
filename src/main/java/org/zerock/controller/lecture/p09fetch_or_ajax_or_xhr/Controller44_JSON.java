package org.zerock.controller.lecture.p09fetch_or_ajax_or_xhr;

import java.awt.PageAttributes.MediaType;

import javax.print.attribute.standard.Media;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean20;

@Controller
@RequestMapping("ex44")
public class Controller44_JSON {

	@RequestMapping("sub")
	public void method() {
		// sub.jsp 포워드void
	}
	
	@PostMapping("sub01")
	public void method1(String name, String address) {
		System.out.println("1번 메소드 일함");
		System.out.println(name);
		System.out.println(address);
	}
	
	@PostMapping("sub02")
	public void method2(@RequestBody String data) {
		System.out.println("2번 메소드 일함");
		System.out.println(data);
	}
	
	@PostMapping("sub03")
	public void method3(@RequestBody JavaBean20 data) {
		// JSON을 해석하여 name=Value 쌍으로 Bean에 저장.  
		//(  pom.xml : jackson databind 라이브러리 추가해야 됨  )
		System.out.println("3번 메소드 일함");
		System.out.println(data);
		
	}
	
	
}
