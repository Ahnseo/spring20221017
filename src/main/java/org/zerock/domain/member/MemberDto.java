package org.zerock.domain.member;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberDto {
	
	//추가 할것.. 성명, 닉네임, 주민번호..?
	
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String email;

	private LocalDateTime inserted;
	
}
