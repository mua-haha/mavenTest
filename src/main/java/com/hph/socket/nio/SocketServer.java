package com.hph.socket.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class SocketServer {
	public static void main(String[] args) throws IOException {
		// 打印本机的IP地址
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("本机的IP地址是" + address.getHostAddress());
		// 创建一个ServerSocket，用于监听客户端Socket的连接请求
		ServerSocket ss = new ServerSocket(8000);
		// 采用循环不断接受来自客户端的请求
		while (true) {
			// 每当接受到客户端Socket的请求，服务器端也对应产生一个Socket
			Socket s = ss.accept();
			s.setTcpNoDelay(true);
			System.out.println("收到客户端请求");
			// 将Socket对应的输出流包装成PrintStream
			PrintStream ps = new PrintStream(s.getOutputStream());
			// 读取 input
			InputStream in = s.getInputStream();
			byte[] bytes = new byte[1024];
			in.read(bytes, 0, bytes.length);
			String data = new String(bytes,"UTF-8");
			System.out.println(data);
			// 进行普通IO操作
			ps.println("您好，"+data);
			// 关闭输出流，关闭Socket
			ps.close();
			in.close();
			s.close();
		}
	}
}
