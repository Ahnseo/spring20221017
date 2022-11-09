package org.zerock.service.board;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.board.BoardDto;
import org.zerock.domain.board.PageInfo;
import org.zerock.mapper.board.BoardMapper;
import org.zerock.mapper.board.ReplyMapper;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Transactional
	public int register(BoardDto board, MultipartFile[] files) {
		
		//(버그 수정 2022.11.09) 제목을 꼭 입력해야하길 바람. => register.jsp => JavaScript 처리
		
		//db 게시물 정보 저장, xml : <insert id="insertBoard" keyProperty="id" useGeneratedKeys="true"> 	 
		int cnt = boardMapper.insertBoard(board);	 
		 

		 //파일 업로드 하기
		 for(MultipartFile file : files) {
			 
			 if(file != null && file.getSize() > 0) { 
					 //db에 파일 정보 저장 : 파일명, 게시물id => db테이블 만들기
					 boardMapper.insertFile(board.getId(), file.getOriginalFilename());
				 //실제 파일이 어디 저장되는지?
				 //board id(PrimaryKey이용한) 여러 새폴더 자동 생성하기
				 File folder = new File("C:\\Users\\user\\Desktop\\study\\upload\\prj1\\board\\" + board.getId());
				 folder.mkdirs();
				 
				 File dest = new File(folder, file.getOriginalFilename());
				 
				 try { 
					 file.transferTo(dest);
				} catch (Exception e) {
					//@Transactional 은 RuntimeException에서만 롤백됨
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			} 
		}
		 
		 
		 return cnt;
	}

	                              // 파라미터 순서 잘지켜라
	public List<BoardDto> listBoard(int page, PageInfo pageInfo, String keyword, String type) {
		int records = 10;
		int offset = (page - 1) * records; 
		
		int countAll = boardMapper.countAll("%"+keyword+"%", type); //SELECT COUNT(*) FROM Board
		//System.out.println(countAll);
		
		int lastPageNumber = (countAll - 1) / records  + 1; 
		
		int leftPageNumber = (page - 1) / 10 * 10 + 1;	
		
		int rightPageNumber = leftPageNumber + 9;
			//System.out.println(lastPageNumber);
			//System.out.println(rightPageNumber);
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
		
		
		return boardMapper.list(offset, records, "%"+keyword+"%", type);
	}

	public BoardDto getBoardById(int id) {
		
		return boardMapper.selectBoardById(id);
	}

	public void modify(int id, Model model) {
		BoardDto board = boardMapper.selectBoardById(id);
		model.addAttribute("board", board);	
	}

	public int update(BoardDto board, MultipartFile[] files, List<String> removeFiles) {
		int cnt = boardMapper.update(board);
		
		//checkbox remove : removefile checkBox 에서 fileName과 boardId 가 일치하면 삭제.
		if(removeFiles != null ) {
			for(String fileName : removeFiles) {
				// db 지우기
				int boardId = board.getId();
				boardMapper.deleteFileByBoardIdAndFileName(boardId, fileName);
				//실제 저장소안의 file 지우기
				String path ="C:\\Users\\\\user\\Desktop\\study\\upload\\prj1\\board\\"+ boardId + "\\" + fileName;
				File file = new File(path); 
				file.delete();
			}
		}
		

		// 1.File table에서 같은 이름의 파일이 있는가? -> 지우기 (덮어씌우려공)
		// 2.File table에 파일명 추가
		// 3.실제 저장소에 파일 추가
		// update는 useGeneratedKeys xxx 하지않는다. 이미 만들어진 boardId를 가져오면 되잖아?
		
		for(MultipartFile file : files) {
			// 1.File table에서 같은 이름의 파일이 있는가? -> 지우기 (덮어씌우려공)
			if (file != null && file.getSize() >0 ) { //파일명이 없으면 ,size() 1로 넘기기때문에				
				int boardId = board.getId();
				String fileName = file.getOriginalFilename();
				boardMapper.deleteFileByBoardIdAndFileName(boardId, fileName);
				boardMapper.insertFile(boardId, fileName);	
				
				// 2.File table에 파일명 추가
				// 3.실제 저장소에 파일 추가
				File folder = new File("C:\\Users\\user\\Desktop\\study\\upload\\prj1\\board\\" + board.getId());
				folder.mkdirs();
				
				File dest = new File(folder, fileName);
				
				try {
					file.transferTo(dest);
				} catch (Exception e) {
					// @Transactional은 RuntimeException에서만 rollback 됨
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
		
		return cnt;
	}
	
	//두가지 일이 하나의 업무이므로 , 트렌젝셔날
	//@Transactional
	public int remove(int id) {
		//1.게시물의 '댓글'들을 먼저 지우기, 실제 현업에서는 지우지않음, 전부 자산이기 때문에, 지웠다는 표시만함.
		replyMapper.deleteByBoardId(id);
		//2.업로드 파일 또한 먼저지워줘야함.
		boardMapper.deleteFilesByBoardId(id);
		//2-2.저장소의 파일 지우기
		String path ="C:\\Users\\\\user\\Desktop\\study\\upload\\prj1\\board\\"+ id;
		File folder = new File(path); 
		File[] listFiles = folder.listFiles(); //폴어안의		
		if(listFiles != null) {	
			for(File file : listFiles) {
				file.delete();
			}
			folder.delete();
		}else {
			folder.delete();
		}
		
		
		
		//int a = 3/0 ; RuntimeException의 경우, 댓글만 지워져서
		//그래서 @Transactional 했어. 맨위에 @Service 와 함께 넣어도 무관하지.
		
		//2.게시물 지우기
		return boardMapper.remove(id);	
	}
	
}
