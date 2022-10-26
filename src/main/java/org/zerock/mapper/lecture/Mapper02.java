package org.zerock.mapper.lecture;

import java.util.List;

public interface Mapper02 {
	List<String> getCustomerNames();
	
	List<Integer> getCustomerIds();
	
	List<Double> getProductPrices();
	
	List<java.time.LocalDate> getBirthDates();
}

