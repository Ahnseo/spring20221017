package org.zerock.service.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.mapper.board.BoardMapper;

@Service
@Transactional
public class boardService {
	
	@Autowired
	private BoardMapper mapper;
	
	public int register(BoardDto board) {
		return mapper.insert(board);
	}

	                              // 파라미터 순서 잘지켜라
	public List<BoardDto> listBoard(int page, PageInfo pageInfo, String keyword, String type) {
		int records = 10;
		int offset = (page - 1) * records; 
		
		int countAll = mapper.countAll("%"+keyword+"%", type); //SELECT COUNT(*) FROM Board
		
		System.out.println(countAll);
		
		int lastPageNumber = (countAll - 1) / records  + 1; 
		
		int leftPageNumber = (page - 1) / 10 * 10 + 1;	
		
		int rightPageNumber = leftPageNumber + 9;
			System.out.println(lastPageNumber);
			System.out.println(rightPageNumber);
			rightPageNumber = Math.min(lastPageNumber, rightPageNumber);
			
				
		int currentPageNumber = page;
		pageInfo.setCurrentPageNumber(currentPageNumber);
		pageInfo.setLastPageNumber(lastPageNumber);
		
		pageInfo.setLeftPageNumber(leftPageNumber);
		pageInfo.setRightPageNumber(rightPageNumber);
		
		//이전 버튼 유무
		boolean hasPrevButton = page > 10;
		int jumpPrevPageNumber = (page - 1) /10 * 10 - 9;
		pageInfo.setHasPrevButton(hasPrevButton);
		pageInfo.setJumpPrevPageNumber(jumpPrevPageNumber);
		
		//다음 버튼 유무
		boolean hasNextButton = page<= ( (lastPageNumber - 1) / 10 * 10);
		int jumpNextPageNumber = (page - 1) /10 * 10 + 11;
		pageInfo.setHasNextButton(hasNextButton);
		pageInfo.setJumpNextPageNumber(jumpNextPageNumber);
		
		return mapper.list(offset, records, "%"+keyword+"%", type);
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
