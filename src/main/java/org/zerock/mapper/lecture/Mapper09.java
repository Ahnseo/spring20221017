package org.zerock.mapper.lecture;

import java.util.List;

import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean16;
import org.zerock.domain.lecture.JavaBean17;

public interface Mapper09 {
	
	String getCusmtomerNameById(int id);
	String getEmployeeFirstNameById(int employeeId);
	
	List<String> getCustomerNameByCityAndCountry(String city ,String country);
	
	String getSupplierNameByCityAndCountry(String country, String city);
	
	String getContactName(JavaBean04 b1);
	
	String getSupplierContactName(JavaBean04 bean2);
	
	//2개의 bean
	List <String> getNameByCategoryPrice(JavaBean16 beanCate, JavaBean17 beanProd);
}
