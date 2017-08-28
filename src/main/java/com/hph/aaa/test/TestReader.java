package com.hph.aaa.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class TestReader {
	public static void main(String[] args) throws Exception {

		File file = new File("C:/1hepenghui/war包/network-mointer.log");
		InputStreamReader read = new InputStreamReader(new FileInputStream(file));// 考虑到编码格式
		BufferedReader bufferedReader = new BufferedReader(read);
		String lineTxt = null;
		List<String> list = new ArrayList<>();
		while ((lineTxt = bufferedReader.readLine()) != null) {
			if (lineTxt.indexOf("--PING--false") != -1) {
				list.add(lineTxt.split("-")[3].split(" ")[1]);
			}
		}
		System.out.println(list.size());
		removeDuplicate(list);
		System.out.println(list.size());
		Collections.reverse(list);
		for(String s:list){
			System.out.println(s);
		}
		

	}

	public static void removeDuplicate(List list) {
		HashSet h = new HashSet(list);
		list.clear();
		list.addAll(h);
	}

}
