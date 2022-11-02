package org.zerock.mapper.board;

import java.util.List;

import org.zerock.domain.board.BoardDto;

public interface BoardMapper {
	
	int insert(BoardDto board);
						
					//파라미터 순서 잘 지켜라
	List<BoardDto> list(int offset, int records, String keyword, String type);

	BoardDto get(int id);
	
	int update(BoardDto board);

	int remove(int id);

	int countAll(String keyword, String type);


}
