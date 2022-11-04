package org.zerock.mapper.lecture;

import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;

public interface Mapper11 {

	int updateCustomer(JavaBean18 c);
	
	JavaBean18 getCustomerById(int id);
	
	int updateSupplier(JavaBean19 s);
	
	JavaBean19 getSupplier(int id);

	int insertSupplier(JavaBean19 s);

	int deleteSupplier(int id);
	
	
	
	
}
