package org.zerock.controller.lecture.p02param;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex12")
public class Controller12 {
	// 같은
	// /ex12/sub01?city=seoul&city=ny&city=tokyo
	@GetMapping("sub01")
	public void method1(@RequestParam(name="city") String city) {
		System.out.println(city);
	}
	// /ex12/sub02?city=seoul&city=ny&city=tokyo
	@GetMapping("sub02")
	public void method2(@RequestParam(name="city") String[] city) {
		System.out.println(Arrays.toString(city));
		System.out.println(city.length);
	}
	// /ex12/sub03?city=seoul&city=ny&city=tokyo
	@GetMapping("sub03")
	public void method3( @RequestParam(name="city") List<String> city) {
		System.out.println(city);
		System.out.println(city.size());
	}
	
	// 위 3개의 @RequestParam value attribute 생략 가능
	@PostMapping("sub04")
	public void method4(String name, String address, int age, String email, String password) {
		System.out.println(name);
		System.out.println(address);
		System.out.println(age);
		System.out.println(email);
		System.out.println(password);
	}
	
}
