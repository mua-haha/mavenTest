package com.hph.aaa.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	
	public static void main(String[] args) throws Exception {
		String path = "C:/11/logs";
		List<String> list = getAllFileByPath(path);
		for(String p:list){
			if(p.endsWith("catalina.out")){
				List<String> rows = readFileByLines(p);
				fileWriter("c:/11/aa.txt", rows.subList(rows.size()-10000,rows.size()));
			}
		}
		
	}
	
	/**
	 * 递归 得到文件夹中所有的文件
	 */
	public static List<String> getAllFileByPath(String path) {
		List<String> list = new ArrayList<>();
		File pathFile = new File(path);
		if (pathFile.isDirectory()) {
			File[] files = pathFile.listFiles();
			for (File f : files) {
				String fPath = f.getAbsolutePath();
				if (f.isDirectory()) {
					List<String> c = getAllFileByPath(fPath);
					list.addAll(c);
				} else {
					list.add(fPath);
				}
			}
		}
		return list;
	}
	/**
	 * 按行写入
	 * 
	 * @param fileName
	 * @param clist
	 * @throws IOException
	 */
	public static void fileWriter(String fileName, List<String> clist) throws IOException {
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
