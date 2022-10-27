package org.zerock.controller.lecture.p07mybatis;

import java.util.List;

import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;
import org.zerock.mapper.lecture.Mapper10;

@Controller
@RequestMapping("ex36")
public class Controller36_delete_insert {

	@Autowired
	private Mapper10 mapper10;
	
	@RequestMapping("sub01")
	public void method1() {
		int cnt = mapper10.removeCustomer();
		if (cnt == 1) {
			System.out.println("1개의 레코드 삭제됨");
		}else {
			System.out.println("레코드가 이미 제거되었거나, 존재하지 않음");			
		}
	}
	
	//파라미터를 받아서 delete
	// /ex36/sub03?id=1
	@RequestMapping("sub03")
	public void method3(@RequestParam(name="id", defaultValue = "0") int id) {
				// 또는 (Interger id)
		int cnt = mapper10.removeCustomerById(id);
		System.out.println(cnt +"개 레코드 삭제");

	}
	// /ex36/sub04?id=1
	@RequestMapping("sub04")
	public void method3(Integer id) {
				
		int cnt = mapper10.removeEmployeeById(id);
		System.out.println(cnt +"개 레코드 삭제");

	}
	//insert into
	@RequestMapping("sub05")
	public void method5() {
		int cnt = mapper10.addCustomer();
		System.out.println(cnt + "개 고객정보 저장됨");

	}
	@RequestMapping("sub06")
	public void method6() {
		int cnt = mapper10.addSupplier();
		System.out.println(cnt + "개 고객정보 저장됨");
	}
	
	// /ex36/sub07?name=choi?
	@GetMapping("sub07")
	public void customerForm() {
		
	}
	@PostMapping("sub07")
	public void method7(JavaBean18 b) {
		int cnt = mapper10.addCustomerBean(b);
		System.out.println(cnt + "개 고객정보 저장됨");

	}
	
	@GetMapping("sub08")
	public String returnThisJsp() {
		return "ex36/sub08";
	}
	@PostMapping("sub08")
	public void method8(@ModelAttribute("supplier") JavaBean19 supplier, RedirectAttributes rttr) {
		int cnt = mapper10.addSupplierBeans(supplier);
		System.out.println(cnt + "개 자료저장됨");
		
		
		//저장한 정보는 jsp에서 나타내기
		
		List <JavaBean19> supplierList = mapper10.getSupplier();		
		supplierList.forEach( e-> System.out.println(e));
		
		rttr.addFlashAttribute("supplierList", supplierList);
		// 콘솔 출력은 되는데, jsp에 addAttribute 안되는건가? ? ?
		
	}
	
	
	
}
