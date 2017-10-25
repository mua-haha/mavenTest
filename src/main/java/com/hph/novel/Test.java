package com.hph.novel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static Map<String, String> map = new HashMap<>();
	// 
	public static String  url = "http://www.5du5.net/book/2/2978/";

	public static void main(String[] args) throws Exception {
		
		Document d = Jsoup.connect(url).get();
		Elements es = d.select("div[id='list']").select("a");
		List<String> list = new ArrayList<>();
		File file = new File("D:/宁小闲御神录.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		for (Element e : es) {
			list.add(e.attr("href"));
			map.put(e.attr("href"), e.text());
		}
		//Collections.sort(list);
		for (String r : list) {
			writeToFile(r, file);
			System.out.println(map.get(r));
		}

	}

	public static void writeToFile(String r, File file) throws Exception {
		String u = url + r;
		Document d = Jsoup.connect(u).get();
		Elements es = d.select("div[id='content']");
		String t = es.get(0).html();
		t = t.replace("&nbsp;", "");
		t = t.replace("<br>", "");
		writeTxtFile( file,map.get(r)+"\r\n\r\n"+t+"\r\n");
	}


	public static void writeTxtFile(File file, String conent) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			out.write(conent +"\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
