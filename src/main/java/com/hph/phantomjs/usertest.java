package com.hph.phantomjs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class usertest {
	public static String getAjaxCotnent(String url) throws Exception {
		Process process = Runtime.getRuntime().exec("E:/phantomjs/phantomjs-2.1.1-windows/bin/phantomjs.exe E:/phantomjs/phantomjs-2.1.1-windows/test/aa.js  " + url);
		Thread.sleep(5000);
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("UTF-8")));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		String content = getAjaxCotnent("http://music.163.com/");
		System.out.println(content);
//		Document d = Jsoup.parse(content);
//		Element e = d.getElementById("g_iframe");
//		System.out.println(e.toString());
	}

}
