package com.hph.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.Charset;

public class Test {
	public static String socket(String data) throws Exception {

		// 客户端请求与本机在端口建立TCP连接
		Socket client = new Socket("192.168.10.65", 8000);
		client.setSoTimeout(10000);
		// 获取Socket的输出流，用来发送数据到服务端
		PrintStream out = new PrintStream(client.getOutputStream());
		// 获取Socket的输入流，用来接收从服务端发送过来的数据
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream(), Charset.forName("UTF-8")));
		out.println(data);
		String echo = buf.readLine();

		if (client != null) {
			// 如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
			client.close(); // 只关闭socket，其关联的输入输出流也会被关闭
		}
		return echo;

	}
	public static void main(String[] args) throws Exception {
		
		String result = socket("5048535186577293891");
		System.out.println(result);
		
		
	}
}
