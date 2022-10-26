package org.zerock.domain.lecture;

import java.time.LocalDate;


import lombok.Data;
@Data
public class JavaBean08 {
	private int id;
	private LocalDate date;
	
	//이미 작성한 Bean 프로퍼티를 사용하고싶다.
	private JavaBean05 employee;
	
}
