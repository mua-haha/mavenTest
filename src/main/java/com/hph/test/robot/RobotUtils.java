package com.hph.test.robot;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JOptionPane;

public class RobotUtils {

	// 鼠标单击,要双击就连续调用
	public static void pressMouse(Robot r, int m, int delay) {
		r.mousePress(m);
		r.delay(10);
		r.mouseRelease(m);
		r.delay(delay);
	}

	// 键盘输入
	public static void pressKeys(Robot r, int[] ks, int delay) {
		for (int i = 0; i < ks.length; i++) {
			r.keyPress(ks[i]);
			r.delay(10);
			r.keyRelease(ks[i]);
			r.delay(delay);
		}
	}
	
	public static void getScreen(Robot robot){
//		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
//		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		robot.delay(30);
		
		JOptionPane.showMessageDialog(null, "结束");
	}
	
	public static void main(String[] args) throws AWTException {
		Robot rb = new Robot();
		//TODO tianjia
		JOptionPane.showMessageDialog(null, "开始");
		RobotUtils.getScreen(rb);
		
	}

}
