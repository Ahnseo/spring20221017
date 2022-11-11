package org.zerock.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.member.MemberDto;
import org.zerock.mapper.member.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public int insertMember(MemberDto member) {
		 
		int cnt = memberMapper.insertMember(member);	
		return cnt;	
	}

	public List<MemberDto> memberList() {
		
		return memberMapper.selectMemberList();
	}

	public MemberDto memberInfoById(String id) {
		
		return  memberMapper.selectMemberInfoById(id);
	}

	public int modifyMemberInfo(MemberDto member) {
		
		int cnt = 0;
		
		try {
			cnt = memberMapper.updateMemberInfo(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	public int removeMemberById(String id) {
		System.out.println(id);
		return  memberMapper.deleteMemberById(id);
		
	}

	
}
