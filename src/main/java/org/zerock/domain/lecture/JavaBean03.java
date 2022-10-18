package org.zerock.domain.lecture;

import lombok.Data;


@Data //pom.xml 스프링빈 설정해놓음.. 
public class JavaBean03 {

	private String name;
	private String className ;
	private String location ;
	private double score;
	private double avg;
}
