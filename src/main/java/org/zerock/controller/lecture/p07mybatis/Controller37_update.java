package org.zerock.controller.lecture.p07mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;
import org.zerock.mapper.lecture.Mapper11;

@Controller
@RequestMapping("ex37")
public class Controller37_update {

	@Autowired
	private Mapper11 mapper11;
	
	@GetMapping("sub01")
	public void updateCustomerGet(Model model ,@RequestParam(name="id", defaultValue = "0") int id) {
		
		// 수정하기전 고객정보 얻기 
		JavaBean18 customerId = mapper11.getCustomerById(id);
		// 모델에 attribute추가 
		model.addAttribute("customer", customerId);
		// 포워드
		
		
	}
	@PostMapping("sub01")
	public String updateCustomerPost(JavaBean18 customer, RedirectAttributes rttr) {
		//1. 파라미터 수집
		//2. 비지니스 로직
		
		int cnt = mapper11.updateCustomer(customer);
		System.out.println(customer.getId()+"번 고객의 "+ cnt + "개 고객 정보 수정 됨");
		//3. add attribute
		rttr.addAttribute("id", customer.getId()); //쿼리스트링을 넣겟음.
		//4. redirect
		return "/ex37/sub01";
	}
	//#####################################################################
	@GetMapping("sub02")
	public void supplierId(@RequestParam(name = "id", defaultValue = "0")int id, Model model) {
		//get방식 id 전송해서 받아와야해.
		JavaBean19 supplierInfo = mapper11.getSupplier(id);
		
		model.addAttribute("supplier", supplierInfo);
	}
	
	@PostMapping("sub02")
	public String updateSupplierPost(JavaBean19 sup, RedirectAttributes rttr) {
		int cnt = mapper11.updateSupplier(sup); // updateSupplier mapper 인터페이스에서 실행시킴
		System.out.println(sup.getId() + "번 공급자 의 "+ cnt + "개 공급자 정보 업데이트 됨"); // 콘솔 확인
		
		//add attribute
		rttr.addAttribute("supplier", sup.getId()); //jsp Post 방식으로도 id를 얻고싶어서 작성
		rttr.addFlashAttribute("message", sup.getId()+ "번 공급자의 정보가 수정 되었습니다.");
		return "redirect:/ex37/sub02";
		
		
		
		
		

	}
}
