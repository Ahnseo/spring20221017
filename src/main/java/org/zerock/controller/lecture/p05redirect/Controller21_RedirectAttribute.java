package org.zerock.controller.lecture.p05redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ex21")
public class Controller21_RedirectAttribute {

	@RequestMapping("sub01")
	public String method1(RedirectAttributes rttr) {
		rttr.addAttribute("name", "seojung");
		rttr.addAttribute("address", "seoul"); // 아직은 한글 깨짐, 영문으로 진행 공부중.

		return "redirect:/ex21/sub02";
	}

	@RequestMapping("sub02")
	public String method2(@RequestParam("name") String name, @RequestParam("address") String address) {
		System.out.println(name);
		System.out.println(address);
		return null;
	}
	
	// 연습)
	// sub03 요청 -> redirect /ex21/sub04?age=99&email=abc@gmail.com
	// RedirectAttribute 사용
	@RequestMapping("sub03")
	public String method3(RedirectAttributes rttr) {
		rttr.addAttribute("age", 99);
		rttr.addAttribute("email", "abc@gmail.com");
		return "redirect:/ex21/sub04";
	}

	@RequestMapping("sub04")
	public void method4(int age, String email) {
		System.out.println(age);
		System.out.println(email);
	}
	//  쿼리스트링의 한계 : String 으로 만 보낼수있음ㅠㅠ.
	//  session으로 해결가능 

}
