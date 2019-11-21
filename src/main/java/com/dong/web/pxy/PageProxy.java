package com.dong.web.pxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("pager") @Lazy @Data
public class PageProxy extends Proxy {
	@Autowired CrawlingProxy cra;
	
	private String search;
	private int rowCount, startRow, endRow,
				pageCount, pageSize, nowPage, startPage, endPage,
				blockCount, blockSize, nowBlock, prevBlock, nextBlock
				;
	private boolean existPrev, existNext;
	public void paging() {
		//pageSize 5, blockSize 5, rowCount 100, nowPage 0
		pageCount =	(rowCount%pageSize!=0)?rowCount/pageSize+1: rowCount/pageSize;
		blockCount = (pageCount%blockSize!=0)?pageCount/blockSize+1: pageCount/blockSize;
		
		startRow = pageSize*nowPage;
		endRow = (nowPage!=(pageCount-1))? startRow +(pageSize-1) : rowCount-1;
		
		nowBlock = nowPage/blockSize;
		startPage = blockSize*nowBlock;
		endPage = (nowBlock!=(blockCount-1))? startPage +(blockSize-1) : pageCount-1;
		
		prevBlock = startPage-blockSize;
		nextBlock = startPage+blockSize;
		
		existPrev = nowBlock !=0;
		existNext = nowBlock != (blockCount-1);
		
	}
}
