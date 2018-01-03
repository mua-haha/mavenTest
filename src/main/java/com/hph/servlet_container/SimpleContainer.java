package com.hph.servlet_container;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 简单的servlet容器
 * @author hepenghui
 *
 */
public class SimpleContainer {

	private boolean shutdown = false;
	private Log log = LogFactory.getLog(this.getClass());

	public static void main(String[] args) {
		SimpleContainer server = new SimpleContainer();

		server.start();

	}

	private void start() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(1234, 1000, InetAddress.getByName("localhost"));
		} catch (IOException e) {
			System.out.println("Server starts failed");
			e.printStackTrace();
			System.exit(1);
		}
		log.info("Server starts successfully.");
		service(serverSocket);

	}

	private void service(ServerSocket serverSocket) {
		while (!shutdown) {
			try {
				processRequest(serverSocket);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private void processRequest(ServerSocket serverSocket) throws IOException {

		log.info("waitting for incoming request ... ");
		Socket socket = serverSocket.accept();
		log.info("receive a request from " + socket.getRemoteSocketAddress().toString());
		InputStream in = socket.getInputStream();
		BaseRequest request = new BaseRequest(in);
		log.info("Request Object ready!");

		OutputStream out = socket.getOutputStream();
		BaseResponse response = new BaseResponse(out);
		ServletProcessor.processServletRequest(request, response);

		socket.close();

	}
}
