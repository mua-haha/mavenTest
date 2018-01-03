package com.hph.aaa.test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		URL url = usertest.class.getClassLoader().getResource("user.txt");

		File file = new File(url.getFile());
		System.out.println(file.getAbsolutePath());
		List<String> list = readFileByLines(file.getAbsolutePath());
		for(String s:list){
			System.out.println(s);
		}
	}
	/**
	 * 按行写入
	 * 
	 * @param fileName
	 * @param clist
	 * @throws IOException
	 */
	public void fileWriter(String fileName, List<String> clist) throws IOException {
		// 创建一个FileWriter对象
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter writer = new BufferedWriter(fw);
		Iterator<String> iterator = clist.iterator();

		while (iterator.hasNext()) {
			writer.write(iterator.next().toString());
			writer.newLine();// 换行
		}
		// 刷新缓冲区
		fw.flush();
		// 关闭文件流对象
		writer.close();
		fw.close();
	}

	/**
	 * 按行 读取
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static List<String> readFileByLines(String fileName) throws Exception {
		File file = new File(fileName);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		// 创建一个集合
		List<String> nums = new ArrayList<String>();
		// 按行读取文件内容，并存放到集合
		while ((tempString = reader.readLine()) != null) {
			nums.add(tempString);
		}
		reader.close();
		// 返回集合变量
		return nums;
	}
	

}
