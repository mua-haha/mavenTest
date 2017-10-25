package com.hph.aaa.test;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class usertest {

//	public static void main(String[] args) throws Exception {
//		Elements s = Jsoup.connect("http://music.163.com/playlist?id=317113395")
//				.get().select("ul[class=f-hide] a");
//		for(Element e:s){
//			System.out.println(e.attr("href"));
//			System.out.println(e);
//		}
//	}
	public static void main(String[] args) throws Exception {
		Document s = Jsoup.connect("http://music.163.com/playlist?id=317113395")
				.get();
		System.out.println(s.toString());
	}
	

}
