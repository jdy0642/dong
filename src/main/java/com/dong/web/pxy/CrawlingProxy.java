package com.dong.web.pxy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("cra") @Lazy
public class CrawlingProxy extends Proxy {
	@Autowired Inven<HashMap<String, String>> inven;
	@Autowired Box<String> box;
	
	public ArrayList<HashMap<String, String>> engCrawling() {
		String url="https://endic.naver.com/?sLn=kr";
		inven.clear();
		
		try {
			Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
			Elements word = rawData.select("div[class=\"txt_origin\"] a");
			Elements mean = rawData.select("div[class=\"txt_trans\"]");
			HashMap<String, String> map = null;
			
			for (int i=0;i<word.size();i++) {
				map = new HashMap<>();
				map.put("word", word.get(i).text());
				map.put("mean", mean.get(i).text());
				inven.add(map);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("==========");
		inven.get().forEach(System.out :: println);
		return inven.get();
	}
	
	public ArrayList<HashMap<String, String>> cgvCrawl() {
		String url = "http://www.cgv.co.kr/movies/?lt=1" ;
		inven.clear();
		
		try {
			final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36"
					+ " (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
			
			Connection.Response homePage = Jsoup.connect(url) 
					.method(Connection.Method.GET) 
					.userAgent(USER_AGENT) 
					.execute();
		
		Document temp = homePage.parse();
		Elements element = temp.select("div.sect-movie-chart");    
		Elements title = element.select("strong.title");
		Elements percent = element.select("strong.percent");
		Elements textinfo= element.select("span.txt-info");
		Elements photo = temp.select("span[class=\"thumb-image\"] img");
		HashMap<String, String> map = null;
		
		for (int i =0; i<title.size();i++) {
			map = new HashMap<>();
			map.put("title", title.get(i).toString());
			map.put("percent", percent.get(i).toString());
			map.put("textinfo", textinfo.get(i).toString());
			map.put("img", photo.get(i).toString());
			inven.add(map);
			}
		
		}	catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("==========");
		inven.get().forEach(System.out :: println);
		return inven.get();
	}	
}
