package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor //모든 필드를 argment(parameter)로 받는 생성자 를 만듬.
@NoArgsConstructor // argment 없는 생성자 추가하기
public class JavaBean6_ArgsConstructor { 
	private String name; 
	private int age;
	
}
