package org.zerock.domain.board;

import lombok.Data;

@Data
public class PageInfo {
	private int lastPageNumber;
	private int leftPageNumber;
	private int rightPageNumber;
	private int currentPageNumber;
	
	private boolean hasPrevButton;
	private int jumpPrevPageNumber;
	
	private boolean hasNextButton;
	private int jumpNextPageNumber;
	
}
