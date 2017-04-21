package com.hph.aaa.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class usertest {
	
	public static void main(String[] args) throws Exception {
		
		String url = "http://wlzx.hxu.edu.cn/UserServlet?method=1&username=admin&password=admin123";
		Document d =  Jsoup.connect(url).get();
		System.out.println(d);
		
	}

}
