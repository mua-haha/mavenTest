package com.hph.test.exeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// file(内存)----输入流---->【程序】----输出流---->file(内存)
		File file = new File("C:/1hepenghui", "addfile.txt");
		try {
			file.createNewFile(); // 创建文件
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 向文件写入内容(输出流)
		String str = "亲爱的小南瓜！";
		byte bt[] = new byte[1024];
		bt = str.getBytes();
		try {
			FileOutputStream in = new FileOutputStream(file);
			try {
				in.write(bt, 0, bt.length);
				in.close();
				// boolean success=true;
				// System.out.println("写入文件成功");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
