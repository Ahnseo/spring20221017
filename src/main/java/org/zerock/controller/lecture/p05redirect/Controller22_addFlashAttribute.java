package org.zerock.controller.lecture.p05redirect;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.lecture.JavaBean03;
import org.zerock.domain.lecture.Student;

@Controller
@RequestMapping("ex22")
public class Controller22_addFlashAttribute {
	
	@RequestMapping("sub01")
	public String method1(Model model) {
		model.addAttribute("name", "ahnseoj");
		return "redirect:/ex22/sub01";
	}
	@RequestMapping("sub02")
	public void method2(Model model) {
		boolean hasName = model.containsAttribute("name");
		System.out.println(hasName);
	}
	
	@RequestMapping("sub03")
	public String method3(HttpSession session) {
		session.setAttribute("name","ahnseoj");
		return "redirect:/ex22/sub04";
	}
	@RequestMapping("sub04")
	public void method4(HttpSession session) {
		String name = (String)session.getAttribute("name");
		System.out.println(name);	
	}
	// 같은 브라우저에서 요청이 온다면, 같은 세션을 사용해서..
	// 이렇게 배우지만, session을 사용하는 것은 위험하데.. 선생님은 어쩃든 잘넘어간다는것을 보여주고 싶었데
	// 연습)
	@RequestMapping("sub05")
	public String method5(HttpSession session) {
		Student s = new Student();
		s.setStudentNumber("s01");
		s.setName("seojung");
		s.setClassName("school");
		
		session.setAttribute("student", s);
		return "redirect:/ex22/sub06";
	}
	@RequestMapping("sub06")
	public void method6(HttpSession sesstion) {
		Student student = (Student)sesstion.getAttribute("student");
		System.out.println(student.getStudentNumber());
		System.out.println(student.getName());
		System.out.println(student.getClassName());
	}
	
	//이제 RedirectAttribute를 사용해서 넘기는 방법을 배우자.
	@RequestMapping("sub07")
	public String method7(RedirectAttributes rttr) {
		Student s = new Student();
		s.setStudentNumber("s01");
		s.setName("seojung");
		s.setClassName("school");
		
		rttr.addFlashAttribute("student",s); // 보내고 세션을 비워준다.
		return "redirect:/ex22/sub08";
	}
	@RequestMapping("sub08")
//	public void method8(@ModelAttribute("student") Student student) { <- 생략 과정
//	public void method8(@ModelAttribute Student student) { <- 생략 과정
	public void method8(Student student) {
		
		System.out.println(student);
		System.out.println("학생번호 : " + student.getStudentNumber());
		System.out.println("학생이름 : " + student.getName());
		System.out.println("클래스이름 : " + student.getClassName());
		
		// 요청을 보낸 후, 
		// sub08 페이지를 새로고침하면, 세션이 삭제되어있음.
		// 아, 그래서 사용하는구나.
	}
	
	//sub09요청 -> redirect  /ex22/sub10 
	// RedirectAttribute 사용해서 객체를 다음 요청에서 사용할수있게 전달
	//객체 타입 : org.zerock.domain.lecture.JavaBean03
	//sub10 요청 
	//모델에 있는 org.zerock.domain.lecture.JavaBean03 타입의 객체내용 출력
	@RequestMapping("sub09")
	public String method9(RedirectAttributes rttr) {
		JavaBean03 b = new JavaBean03();
		b.setName("JUNG");
		b.setClassName("Class 2");
		b.setLocation("GangNam");
		b.setScore(88);
		b.setAvg(85.5);
		//addFlashAttribute :쿼리스트링에 안붙이고, 세션에 붙여서 넘기는 작업, 넘기고나서 세션 삭제함.. 음 보안이 철저하넹
		rttr.addFlashAttribute("bean",b);
		return "redirect:/ex22/sub10";
	}
	@RequestMapping("sub10")
	public void method10(@ModelAttribute("bean") JavaBean03 bean) {
		System.out.println(bean);
		System.out.println(bean.getName());
		System.out.println(bean.getClassName());
		System.out.println(bean.getLocation());
		System.out.println(bean.getScore());
		System.out.println(bean.getAvg());
	}
}	
