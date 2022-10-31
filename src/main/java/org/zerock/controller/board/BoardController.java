package org.zerock.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.board.BoardDto;
import org.zerock.service.board.boardService;

@Controller
@RequestMapping("board")
public class BoardController {

	@Autowired
	private boardService service;

	@PostMapping("register")
	public String register(BoardDto board, RedirectAttributes rttr) {
		// 잘 동작하는지?
		System.out.println(board);
		
		// 비지니스 로직(Service)
		int cnt = service.register(board);
		
		if (cnt==1) {
			rttr.addFlashAttribute("message", "새 게시물이 등록되었습니다.");
		}else {
			rttr.addFlashAttribute("message", "새 게시물이 등록되지 않았습니다.");
		}	
		// /board/list 로 redirect
		return "redirect:/board/list";
	}

	// board/register
	@GetMapping("register")
	public void register() {
		// forward -> list register (게시물 작성 view로 바로 포워딩)
		// WEB-INF/views/board/register
	}

	@GetMapping("list")
	public void list(Model model) {
		// request param
		// 비지니스 로직
		List<BoardDto> list = service.listBoard();
		// add attribute
		model.addAttribute("boardList", list);
		// forward -> list view
	}
	
	@GetMapping("get")
	public void get(Model model ,@RequestParam(name = "id") int id) { 
					            //@RequestParam(name = "id") 생략가능
		//req param
		//비지니스 로직 (db에서 게시물 가져오기)
		BoardDto board = service.get(id);
		System.out.println(board); //콘솔 확인
		
		//add attribute
		model.addAttribute("board", board);
		
		//forward / redirect
		//get.jsp		
	}
	
	@GetMapping("modify")
	public void modify(Model model, int id) {
		BoardDto board = service.get(id);
		model.addAttribute("board", board);
	}
	
	@PostMapping("modify")
	public String modify(BoardDto board, RedirectAttributes rttr) {
		int cnt = service.update(board);
		if (cnt==1) {
			rttr.addFlashAttribute("message", board.getId()+ "번 게시물이 수정되었습니다.");
		}else {
			rttr.addFlashAttribute("message", board.getId()+"번 게시물이 수정되지 않았습니다.");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("remove")
	public String remove(int id, RedirectAttributes rttr) {
		int cnt = service.remove(id);
		if (cnt==1) {
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제 되었습니다.");
		}else {
			rttr.addFlashAttribute("message", id + "번 게시물이 삭제되지 않았습니다..");
		}
		return "redirect:/board/list";
	}
}




