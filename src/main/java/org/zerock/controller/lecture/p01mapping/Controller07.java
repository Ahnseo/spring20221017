package org.zerock.controller.lecture.p01mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex07")
public class Controller07 {
	
	@GetMapping("sub01")
	public void method1() {
		System.out.println("get method1 일함");

	}
	
	@GetMapping(value="sub01", params="name")
	public void method2(){
		System.out.println("좀더 구체적인 params=\"name\"있는 method2 일함");
	}
	
	//get방식 sub02 경로
	@GetMapping(value = "sub02")
	public void method3() {
		System.out.println("메소드3");
	}
	
	//get방식 sub02 address request params
	@GetMapping(value = "sub02", params = "adress")
	public void method4() {
		System.out.println("메소드4");
	}
	
	//get방식 sub02 address request params
		@GetMapping(path = "sub03", params = "adress=seoul")
		public void method5() {
			System.out.println("메소드5");
		}
	//get방식 sub02
		@GetMapping(path = "sub03")
		public void method6() {
			System.out.println("메소드6");
		}	
		
		
		
		@GetMapping(path ="sub04")
		public void method7() {
			System.out.println("메소드7");
		}
		
		@GetMapping(path="sub04", params= {"name","age"})
		public void method8() {
			System.out.println("메소드8 params 여럿 ,\"name\",\"age\" 동시에 있어야 작동함");
		}
	
	
}
