package org.zerock.mapper.stock;

import java.util.List;

import org.zerock.domain.stock.Stock;

public interface StockMapper {
	
	List<Stock> select();

	int insert(Stock stock);
	

}
