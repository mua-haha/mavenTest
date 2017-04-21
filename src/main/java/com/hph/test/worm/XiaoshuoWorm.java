package com.hph.test.worm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class XiaoshuoWorm {

	public static void getInfo() throws IOException {
		File file = new File("C:/1hepenghui/aa.txt");
		String url = "http://www.37zw.com/2/2790/";
		Document doc = Jsoup.connect(url).get();
		Element es = doc.select("div[class=box_con]").get(1);
		Elements as = es.select("a");
		FileOutputStream fos = new FileOutputStream(file);
		System.out.println(as.size());
		for (int i = 0; i < as.size(); i++) {
			if(i> 900){
				String u = url + as.get(i).attr("href");
				Document d = Jsoup.connect(u).get();
				
				System.out.println(as.get(i).text());
				
				String yizhang = "第"+i+"章 "+as.get(i).text() + d.getElementById("content").text();
				fos.write(yizhang.getBytes());
			}
		}
		fos.close();
	}


	public static void main(String[] args) throws IOException {
		XiaoshuoWorm.getInfo();
		// XiaoshuoWorm.write("bbbbbbbbbb");
	}

}
