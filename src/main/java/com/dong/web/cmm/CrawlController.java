package com.dong.web.cmm;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dong.web.pxy.Box;
import com.dong.web.pxy.CrawlingProxy;
import com.dong.web.pxy.Inven;

@RestController
@RequestMapping("/crawl")

public class CrawlController {
	
	@Autowired CrawlingProxy cra;
	@Autowired Box<String> box;
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
	public void bringBugs(){
		System.out.println("bugs");
	}
}
