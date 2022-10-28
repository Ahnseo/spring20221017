package org.zerock.controller.lecture.p99coffee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.lecture.CoffeeDto;
import org.zerock.mapper.lecture.CoffeeMapper;

@Controller
@RequestMapping("/coffeeSample")
public class CoffeeController {
	
	@Autowired
	private CoffeeMapper mapper;
	
	@GetMapping("coffee")
	public void form(CoffeeDto c, Model model) {
		
		List <CoffeeDto> list = mapper.CoffeeList(c);
		
		model.addAttribute("coffeeList", list);

	}
	
	@PostMapping("coffee")
	public String UpdateMethod(CoffeeDto coffee, RedirectAttributes rttr ) {
		CoffeeDto uc = mapper.updateCoffee(coffee); //업데이트 실행
		rttr.addAttribute("coffee", uc);
		return "redirect:/coffeeSample/coffee";
	}
}
