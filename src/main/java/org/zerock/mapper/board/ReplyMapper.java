package org.zerock.mapper.board;

import java.util.List;

import org.zerock.domain.board.ReplyDto;

public interface ReplyMapper {

	int insert(ReplyDto reply);

	List<ReplyDto> selectReplyByBoardId(int boardId);

	int removeReply(int id);

	int updateReply(ReplyDto reply);

	int selectReplyById(int id);

	int deleteByBoardId(int id);

	int replyGetId(int id);

	ReplyDto getReplyById(int id);

	
}
