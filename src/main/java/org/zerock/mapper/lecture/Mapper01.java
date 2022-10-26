package org.zerock.mapper.lecture;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Select;

public interface Mapper01 {
	
	@Select("SELECT NOW()")
	public String getCurrentTime();
	
	@Select("SELECT CustomerName FROM w3schools.Customers WHERE CustomerId = 77")
	public String getCustomerName();
	// 예전방식은 1. 커넥션 2.stmt 3.rs 4.rs탐색 5.close()  6.checked exception
	// 하지만, 지금부터 myBatis를 이용하여 , @Select( 쿼리작성 )
	// 복잡한 쿼리작성은 인터페이스이름과 같은 xml 파일 추가해서 코드작성
	
	public String getEmployeeName();
	// xml파일에 작성한 쿼리를 실행할 것임.
	
	public String getProductName();
	
	public double getPrice();
	
	public int getQuantity();
	
	public LocalDate getBirthDate();
}
