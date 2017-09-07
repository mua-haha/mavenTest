package com.hph.socket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FileUtils {
	
	/**
	 * 按行写入
	 * 
	 * @param fileName
	 * @param clist
	 * @throws IOException
	 */
	public static void fileWriter(String fileName, List<String> clist) throws IOException {
		// true 表示追加
		FileWriter fw = new FileWriter(fileName, true);
		BufferedWriter writer = new BufferedWriter(fw);
		Iterator<String> iterator = clist.iterator();

		while (iterator.hasNext()) {
			String next = iterator.next().toString();
			if(!"".equals(next)){
				writer.write(next);
				writer.newLine();// 换行
			}
		}
		// 刷新缓冲区
		fw.flush();
		// 关闭文件流对象
		writer.close();
		fw.close();
	}

}
