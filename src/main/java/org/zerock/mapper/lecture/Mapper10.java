package org.zerock.mapper.lecture;

import java.util.List;

import org.zerock.domain.lecture.JavaBean18;
import org.zerock.domain.lecture.JavaBean19;

public interface Mapper10 {
	
	// stmt.executeUpdate  -> 리턴 1 or 0
	// sptmt.executeUpdate -> 리턴 1 or 0
	// 사실 void 로 리턴 받지않아도 됨
	// 별일 없으면, 리턴 int로 두어라
		//removeCustomer
		int removeCustomer();
		
		int removeCustomerById(int id);	
		int removeEmployeeById(int id);
		
		//addCustomer
		int addCustomer();
		int addSupplier();
		int addCustomerBean(JavaBean18 customer);
		
		//insert & select
		int addSupplierBeans(JavaBean19 supplier);
		List <JavaBean19> getSupplier();
		
		int insertSupplierAndGetKey(JavaBean19 supplier);
		
		int getSupplierAndGeneratedKey(JavaBean19 s);
		
		
}
