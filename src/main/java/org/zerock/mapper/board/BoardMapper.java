package org.zerock.mapper.board;

import java.util.List;

import org.zerock.domain.board.BoardDto;

public interface BoardMapper {
	
	int insert(BoardDto board);

	List<BoardDto> list();

	BoardDto get(int id);
	
	int update(BoardDto board);

	int remove(int id);


}
