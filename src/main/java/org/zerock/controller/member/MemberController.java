package org.zerock.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.member.MemberDto;
import org.zerock.service.member.MemberService;


@Controller
@RequestMapping("member")
public class MemberController {
	
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("signup")
	public void signup() {
		//void 포워드 일 함
	}
	
	@PostMapping("signup")
	public String signupPost(@ModelAttribute(name="member") MemberDto member,
							RedirectAttributes rttr){
		//System.out.println(member);
		
		int cnt = memberService.insertMember(member);
		
		if (cnt == 1) {
			rttr.addFlashAttribute("message", "회원가입 되었습니다.");
			return "redirect:/board/list";
		}else {
			
			rttr.addFlashAttribute("message", "회원가입에 실패하였습니다.");
			return "redirect:/member/signup";
		}
	}
	@GetMapping("list") //read
	public void memberListGet(Model model) {
		model.addAttribute("memberList", memberService.memberList());

	}
	
	@GetMapping( {"info", "modify"} ) //{"info", "modify"} 둘다 하는일이 같아서.
	public void memberInfoById(String id, Model model) {
		MemberDto memberInfo = memberService.memberInfoById(id);
		model.addAttribute("member", memberInfo);
		
	};
	
	@PostMapping("modify")
	public String modifyMemberInfo( MemberDto member, RedirectAttributes rttr) {
		int cnt = memberService.modifyMemberInfo(member);
		rttr.addAttribute("id", member.getId());
		
		if(cnt == 1) {
			rttr.addFlashAttribute("message", "회원정보가 수정되었습니다.");
			return "redirect:/member/info";
		}else {
			rttr.addFlashAttribute("message", "회원정보가 수정되지 않았습니다.");
			return "redirect:/member/modify";
		}
	}
	
	@PostMapping("remove")
	public String removeMemberById(@RequestParam(name="id")String id, RedirectAttributes rttr) {
		System.out.println(id);
		int cnt = memberService.removeMemberById(id);
		
		rttr.addFlashAttribute("message", "회원 탈퇴 되었습니다.");			
		
		return "redirect:/board/list";
	}
	
	
}
