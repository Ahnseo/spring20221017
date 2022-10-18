package org.zerock.controller.lecture.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex11")
public class Controller11_결국이렇게사용한다 {

	// 기본타입과String 은 @RequestParam 생략가능
	// /ex11/sub01?address=seoul
	@GetMapping("sub01")
	public void method1(@RequestParam(name="address") String address) {
		System.out.println(address);
	}
	
	// @RequestParam(name="address") String address 같으면,
	//  @RequestParam value속성 생략 가능
	// /ex11/sub02?address=seoul
	@GetMapping("sub02")
	public void method2( String address) {
		System.out.println(address);
	}
	// 다시 언급.
	@GetMapping("sub03")
	public void method3( String address) {
		// 메소드 파라미터가 기본타입(8개, 또는 Wrapper),String
		//@RequestParam 이 붙은 것으로 간주함.
		System.out.println(address);
	}
	
	//### 결국, 생략에 생략을 거쳐서 이렇게 사용되는데, 모르면, 잘안보임 ####################
	//연습) /ex11/sub04?city=NewYork&age=90&name=donald
	@GetMapping("sub04")
	public void method4(String city, int age, String name) {
		System.out.println(city);
		System.out.println(age);
		System.out.println(name);
	}
}
