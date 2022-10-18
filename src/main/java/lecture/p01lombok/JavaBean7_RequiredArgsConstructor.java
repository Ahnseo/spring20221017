package lecture.p01lombok;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 필드 초기화 생성자
@AllArgsConstructor
//@NoArgsConstructor 이건 안되네, 무조건 final 필드 초기화 해줘야하니까
public class JavaBean7_RequiredArgsConstructor {
	private final String name;
	private final int age;
	private String address;
}
