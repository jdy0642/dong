package com.dong.web.cmm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dong.web.pxy.Box;
import com.dong.web.pxy.CrawlingProxy;
import com.dong.web.pxy.Inven;
import com.dong.web.pxy.PageProxy;

@RestController
@RequestMapping("/crawl")

public class CrawlController {
	
	@Autowired CrawlingProxy cra;
	@Autowired PageProxy pager;
	@Autowired Box<Object> box;
	@Autowired Inven<String> inven;
	
	@GetMapping("/naver")
	public ArrayList<HashMap<String, String>> bringNaver(){
		System.out.println("네이버 컨트롤러");
		return cra.engCrawling();
	}
	@GetMapping("/cgv")
	public  ArrayList<HashMap<String, String>> bringCgv()  {
		System.out.println("cgv 컨트롤러");
		return cra.cgvCrawl();
	}
	@GetMapping("/bugs")
	public Map<?,?> bringBugs(){
		System.out.println("bugs 컨트롤러");
		ArrayList<HashMap<String, String>> list = cra.bugsCrawling();
		pager.setRowCount(list.size());
		pager.setBlockSize(5);
		pager.setPageSize(10);
		pager.setNowPage(0);
		pager.paging();
		ArrayList<HashMap<String, String>> temp = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(i >= pager.getStartRow()&& i <= pager.getEndRow()) {
				temp.add(list.get(i));
			}
			if(i>pager.getEndRow()) {
				break;
			}
		}
		box.put("pager", pager);
		box.put("list", temp);
		System.out.println("페이져: "+box.get("pager").toString());
		return box.get();
	}
}
