package com.hph.socket;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

import org.springframework.util.StopWatch;

public class Test {
	public static String socket(String data) throws Exception {

		// 客户端请求与本机在端口建立TCP连接
		Socket client = new Socket("192.168.70.195", 7000);
//		client.setSoTimeout(10000);
		// 获取Socket的输出流，用来发送数据到服务端
		PrintStream out = new PrintStream(client.getOutputStream());
		// 获取Socket的输入流，用来接收从服务端发送过来的数据
		InputStream is = client.getInputStream();
		
		out.write(data.getBytes("UTF-8"));
		byte[] bytes = new byte[1024];
		is.read(bytes, 0, bytes.length);
		String echo = new String(bytes, "UTF-8");

		if (client != null) {
			// 如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
			client.close(); // 只关闭socket，其关联的输入输出流也会被关闭
		}
		return echo;

	}
	public static void main(String[] args) throws Exception {
//		for(int i=0;i<100;i++){
//			String result = socket("5048535186577293891");
//			System.out.println(result);
//		}
		
		StopWatch stopWatch = new StopWatch("执行时间统计");
		for(int i=0;i<10;i++){
			stopWatch.start(i+"次请求");
			String result = socket("5048535186577293891").trim();
			System.out.println("结果："+result);
			stopWatch.stop();
		}
		
		System.out.println(stopWatch.prettyPrint());
		
	}
}
