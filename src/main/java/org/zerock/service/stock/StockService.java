package org.zerock.service.stock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.stock.Stock;
import org.zerock.mapper.stock.StockMapper;

@Service
public class StockService {

	@Autowired
	private StockMapper mapper;
	
	public List<Stock> getList() {
		
		return mapper.select();
		
	}

	public void createProduct(Stock stock) {
		mapper.insert(stock);
		
	}
	
}
