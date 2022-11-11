package org.zerock.mapper.member;

import java.util.List;

import org.zerock.domain.member.MemberDto;

public interface MemberMapper {

	int insertMember(MemberDto member);

	List<MemberDto> selectMemberList();

	MemberDto selectMemberInfoById(String id);

	int updateMemberInfo(MemberDto member);

	int deleteMemberById(String id);

}
