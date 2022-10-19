package org.zerock.controller.lecture.p04attribute;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.lecture.JavaBean03;
import org.zerock.domain.lecture.Student;

import lombok.Data;

@Controller
@RequestMapping("ex17")
public class Controller17_Model_AddAttribute {

	@RequestMapping("sub01")
	//                  Model model : 스프링에서 model은 attribute들을 담아두는 객체로 이미 정해놓음. 
	//                                jsp에서 바로꺼내쓸수있음
	public void method1(Model model) {
		//addAttribute(Stirng str, Object o)
		model.addAttribute("myName","ahnseoj");
	}
	
	//연습) 
	// /ex17/sub02 요청
	// /WEB-INF/views/ex17/sub02.jsp 포워드
	// addAttribute : email : abc@naver.com
	
	@RequestMapping("sub02")
	public void method2(Model model) {
		model.addAttribute("myEmail", "abc@naver.com");

	}
	
	@RequestMapping("sub03")
	public void method3(Model model) {
		model.addAttribute("name", "AHN SEOJUNG");
		model.addAttribute("age", 30);
		model.addAttribute("address", "당산동");
		model.addAttribute("email", "ahnseoj@gmail.com");
	}
	
	@RequestMapping("sub04")
	public void method4(Model model) {
		JavaBean03 obj = new JavaBean03();
		obj.setName("SeoJung");
		obj.setClassName("중앙정보처리학원");
		obj.setLocation("강남");
		obj.setScore(87.8);
		obj.setAvg(89.6);
	
		model.addAttribute("student", obj);
	}
	
	@RequestMapping("sub05")
	public void method5(Model model) {
		Student s = new Student();
		s.setName("ahn");
		s.setClassName("중앙정보처리학원");
		s.setStudentNumber("s11");
//		model.addAttribute("student", s);
		//클래스 이름과 attr이름이 같으면, 생략가능하다.
		model.addAttribute(s);
	}
}


