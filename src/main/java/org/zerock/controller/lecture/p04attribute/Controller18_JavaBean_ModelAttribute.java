package org.zerock.controller.lecture.p04attribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.lecture.JavaBean01;
import org.zerock.domain.lecture.JavaBean02;
import org.zerock.domain.lecture.Student;

@Controller
@RequestMapping("ex18")
public class Controller18_JavaBean_ModelAttribute {
	
	// /ex18/sub01?name=ahn&address=seoul&email=ahnseoj@gmail.com
	@RequestMapping("sub01")
	public void method1(@ModelAttribute("bean") JavaBean01 b) {
		//                               bean 이라는 이름으로 넣겟다.
		//{안에}코드가 없어도, 검색창에 , /ex18/sub01?name=ahn&address=seoul&email=ahnseoj@gmail.com 넣기만해도
		// sub01.jsp에 el값으로 얻을수있다.
		// 쉽게~ 한번에 넣을 수있게 되었따. 꿀..이다. 
	}
	
	@RequestMapping("sub02")
	public void method2(@ModelAttribute("bean") JavaBean02 b) {
		// 검색창에 넣기
		// /ex18/sub02?name=ahnseoj&age=30&address=seoul&email=ahnseoj@gmail.com&password=asdfqwerasdfqwer
	}
	
	@RequestMapping("sub03")
	//                  클래스명과 attr명이 같다면, 생략가능하다.
	public void method3(@ModelAttribute("student") Student s) {
		s.setStudentNumber("s01");
		s.setName("ahn");
		s.setClassName("학원");
	}
	@RequestMapping("sub04")
	//                  클래스명과 attr명이 같다면, 생략가능하다.
	public void method4(@ModelAttribute Student s) {
		s.setStudentNumber("s01");
		s.setName("ahn");
		s.setClassName("학원");
	}
	//##################################################################################################################
	@RequestMapping("sub05")
	//                  전부 생략해도, @ModelAttribute( "student" )로 lowerCamerCase 저장되어 있으니,  
	//                                ${student }  jsp파일에서  el코드로 꺼내쓰면 된다.
	public void method5(Student s) {
		s.setStudentNumber("s01");
		s.setName("ahn");
		s.setClassName("학원");
	}
	//###################################################################################################################
	
}
