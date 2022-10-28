package org.zerock.mapper.lecture;

import java.util.List;

import org.zerock.domain.lecture.CoffeeDto;

public interface CoffeeMapper {

	List <CoffeeDto> CoffeeList(CoffeeDto c);
	CoffeeDto updateCoffee(CoffeeDto c);
}
