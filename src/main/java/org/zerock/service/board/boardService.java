package org.zerock.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.zerock.domain.board.BoardDto;
import org.zerock.mapper.board.BoardMapper;

@Service
@Transactional
public class boardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public int register(BoardDto board) {
		return mapper.insert(board);
	}

	public List<BoardDto> listBoard() {
		return mapper.list();
	}

	public BoardDto get(int id) {
		return mapper.get(id);
	}

	public void modify(int id, Model model) {
		BoardDto board = mapper.get(id);
		model.addAttribute("board", board);	
	}

	public int update(BoardDto board) {
		return mapper.update(board);
	}

	public int remove(int id) {
		return mapper.remove(id);	
	}	
}
