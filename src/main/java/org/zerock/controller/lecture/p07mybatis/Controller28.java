package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.mapper.lecture.Mapper01;

@Controller
@RequestMapping("ex28")
public class Controller28 {

	//myBatis : 인터페이스를 만들면 , 클래스 + 자바빈 까지 생성해 줌.
	@Autowired
	private Mapper01 mapper;
	
	@RequestMapping("sub01")
	public void method1() {
		String time = mapper.getCurrentTime();
		System.out.println(time);
	}
}
