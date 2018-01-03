package com.hph.multiThread;

public class MainTest {
	public static void main(String[] args) {
		
		MessageSender ms = new MessageSender();
		for(int i=0;i<100;i++){
			ms.send();
		}
	}

}
