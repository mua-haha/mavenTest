/**   
 * Copyright © 2017 公司名. All rights reserved.
 * 
 * @Title: MainRunner.java 
 * @Prject: batch-decrypt
 * @Package: org.batch.decrypt 
 * @Description: TODO
 * @author: Administrator   
 * @date: 2017年1月6日 上午9:47:18 
 * @version: V1.0   
 */
package com.hph.key;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MainTest {
	public static void main(String[] args) throws Exception {
		String path = "F:/1Data/2017-09-06-93304条秘钥";
		
		String content = "";
		String key = "";
		
		// 检查文件
		File pathFile = new File(path);
		File[] files = pathFile.listFiles();
		for (File f : files) {
			if(f.getName().endsWith("张.txt_TK_key")){
				key = readFileByLines(f.getAbsolutePath());
			}
			if(f.getName().endsWith("张.txt_TK")){
				content = readFileByLines(f.getAbsolutePath());
			}
			
		}
		System.out.println("content: "+content);
		System.out.println("key: "+key);
		String result = BatchDecryptFactory.getBatchDecryptUtils().decrypt(content, key);
		System.out.println("解密TK: "+result);
		for (File f : files) {
			if(f.getName().endsWith(".txt")){
				BatchAuthentication.checkKey(f.getAbsolutePath(), result);
			}
		}
	}
	
	/**
	 * 按行 读取
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static String readFileByLines(String fileName) throws Exception {
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
		return nums.get(0);
	}
}
