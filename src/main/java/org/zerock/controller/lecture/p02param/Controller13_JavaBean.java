package org.zerock.controller.lecture.p02param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

//자바빈 클래스 임포트
import org.zerock.domain.lecture.JavaBean01;
import org.zerock.domain.lecture.JavaBean02;
import org.zerock.domain.lecture.JavaBean03;

// 이제 자바빈 사용하려한다.
// 회사마다 자바빈 클래스 파일을 만드는곳을 다르지만,
// 지금은 org.zerock / domain이라는 폴더를 만들어 넣겠다.
@Controller
@RequestMapping("ex13")
public class Controller13_JavaBean {
	// /ex13/sub01?name=park&address=seoul
	@GetMapping("sub01")
	public void method1(JavaBean01 bean1) {
		System.out.println("메소드1 일함");
		
		System.out.println(bean1.getName());
		System.out.println(bean1.getAddress());
	}
	
	@GetMapping("sub02")
	public void method3(JavaBean02 bean2) {
		System.out.println(bean2.getName());
		System.out.println(bean2.getAge());
		System.out.println(bean2.getAddress());
		System.out.println(bean2.getEmail());
		System.out.println(bean2.getPassword());
	}
	@GetMapping("sub03")
	// @RequestParam : 기본타입8 + String 
	// @ModelAttribute : 그 이외 타입들, 즉 자바빈은 @ModelAttribute Annotation으로 처리됨
	public void method3(@ModelAttribute JavaBean03 bean3){
		System.out.println(bean3.getName());
		System.out.println(bean3.getClassName());
		System.out.println(bean3.getLocation());
		System.out.println(bean3.getScore());
		System.out.println(bean3.getAvg());
	}
	//@ModelAttribute 다음 페이지에서 배우자
}
