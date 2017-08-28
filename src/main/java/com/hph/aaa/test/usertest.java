package com.hph.aaa.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class usertest {
	public static void getAjaxCotnent(String url) throws Exception {
		Process process = Runtime.getRuntime().exec("C:/phantomjs/phantomjs-2.1.1-windows/bin/phantomjs.exe C:/phantomjs/phantomjs-2.1.1-windows/hello/hello.js  " + url);
		Thread.sleep(5000);
		BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.forName("GBK")));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void main(String[] args) throws Exception {
		getAjaxCotnent("http://music.163.com");
	}

}
