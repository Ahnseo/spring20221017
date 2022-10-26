package org.zerock.mapper.lecture;

import org.zerock.domain.lecture.JavaBean04;
import org.zerock.domain.lecture.JavaBean05;
import org.zerock.domain.lecture.JavaBean06;

public interface Mapper03 {

	//여러 컬럼과 여러 레코드 얻기
	JavaBean04 getCustomer();
	JavaBean05 getEmployee();
	
	//조회된 컬럼명(column)과 bean의 필드명(property)이 같을 때 
	//xml파일 resultMap 생략가능 함.
	JavaBean05 getEmployee2();
	
	//또한, xml파일 별칭을 넣어 bean property를 맞춰서, 
	//resultMap 생략함
	JavaBean04 getCustomer2();
	
	JavaBean06 getProduct();
}
