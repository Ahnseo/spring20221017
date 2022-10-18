package lecture.p01lombok;

import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;


@Data // 아래 5개의 annotation을 한번에 적용함. 개꿀.. 
//@ToString
//@EqualsAndHashCode
//@Getter
//@Setter
//@RequiredArgsConstructor : final 필드 생성자 
// 근데, final필드가 없으니까..parameter없는 생성자 만듬.  
public class JavaBean5_Data {
	private String name;
	private int score;
	
}
