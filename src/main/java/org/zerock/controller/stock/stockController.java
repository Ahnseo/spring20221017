package org.zerock.controller.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.stock.Stock;
import org.zerock.service.stock.StockService;

@Controller
@RequestMapping("stock")
public class stockController {

	@Autowired
	private StockService service;
	
	
	@PostMapping("register")//C
	public void register(Stock stock) {
		service.createProduct(stock);
	}
	@GetMapping("register")
	public void forwardRegister() { }
	
	@GetMapping("list")//R
	public void getlist(Model model) {
		List<Stock> list = service.getList();
		
		model.addAttribute("stockList", list);
		
	}
}
