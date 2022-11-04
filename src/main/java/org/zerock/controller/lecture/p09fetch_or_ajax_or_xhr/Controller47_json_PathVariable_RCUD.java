package org.zerock.controller.lecture.p09fetch_or_ajax_or_xhr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;
import org.zerock.mapper.lecture.Mapper11;


@Controller
@RequestMapping("ex47")
public class Controller47_json_PathVariable_RCUD {
	
	// jdbc : w3schools 
	
	@Autowired
	private Mapper11 mapper;
	
	
	@RequestMapping("sub")
	public void Method() {
		
	}
	@GetMapping("sub01")
	@ResponseBody
	public Map<String, String > method1() {
		 
		return Map.of("address", "seoul", "name","ahnseoj", "job","student");

	}
	@GetMapping("sub02")
	@ResponseBody
	public Map<String, Object > method2() {
		 
		return Map.of(  "color", List.of("blue", "red"), 
						"model", 5,
						"country","USA");
	}
	
	@GetMapping("sub04")
	@ResponseBody
	public JavaBean18 method4(JavaBean18 bean){
		 // id=30의 고객정보
		bean = mapper.getCustomerById(30);	
		System.out.println(bean);
		return bean ;
	}
	// ######## @PathVariable  #########################
	@GetMapping("sub06/{id}")
	@ResponseBody
	public JavaBean18 method6(JavaBean18 bean, @PathVariable Integer id){
		 // jsp -> input ->id
		bean = mapper.getCustomerById(id);
	
		return bean ;
	}
	@GetMapping("sub07/{id}")
	@ResponseBody
	public JavaBean19 method7(JavaBean19 sup, @PathVariable Integer id) {
		sup = mapper.getSupplier(id);
		return sup;
	}
	
	@GetMapping("sub08/{id}")
	@ResponseBody
	public Map<String, Object> method8( @PathVariable Integer id ) {
		Map<String, Object> map = new HashMap<>();
		JavaBean18 customer = mapper.getCustomerById(id);		
		
		if(customer != null) {			
			map.put("customer", customer);
			map.put("message", "고객정보가 조회 되었습니다.");
		}else {
			map.put("message", "고객정보가 조회되지 않았습니다.");			
		}
		return map;
	}
	
	//read from id
	@GetMapping("sub09/{id}")
	@ResponseBody
	public Map<String, Object> method9(@PathVariable int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		JavaBean19 suppl = mapper.getSupplier(id);
		if(suppl != null) {		
			map.put("supplier", suppl);
			map.put("message", "공급자 조회되었습니다.");
		}else {
			map.put("message", "공급자 죄회되지 않았습니다.");		
		}
		return map;
	}
	
	//update
	@PutMapping("sub10")
	@ResponseBody
	public Map<String, String> method10(@RequestBody JavaBean18 customer) {
		Map<String, String> map = new HashMap<>();
		int cnt = mapper.updateCustomer(customer);
		if (cnt == 1) {				
			map.put("message", customer.getId() + "번 고객정보가 변경되었습니다.");
		}else {
			map.put("message", customer.getId() + "번 고객정보가 변경되지 않았습니다.");
		}
		return map;
	}
	
	//create
	@PostMapping("sub13")
	@ResponseBody
	public Map<String, String> method13(@RequestBody JavaBean19 supplier){
		Map<String, String> map = new HashMap<>();
		
		int cnt = mapper.insertSupplier(supplier);
		if (cnt == 1) {
			map.put("message", supplier.getId() + "번 공급자 정보가 저장 되었습니다.");
		}else {
			map.put("message", "공급자 정보가 저장되지 않았습니다.");
		}
		
		return map;
	}
	
	//delete
	@DeleteMapping("sub15")
	@ResponseBody
	public Map<String, String> method15(@RequestBody Integer id){
		Map<String, String> map = new HashMap<String, String>();
		
		int cnt = mapper.deleteSupplier(id);
		if (cnt == 1 ) {
			map.put("message", "삭제되었습니다.");
		}else {
			map.put("message", "삭제되지 않았습니다.");
			
		}
		return map;
		
	}
	
	
	
	
	
	
}
