package com.hph.algorithm;

/**
 * 屌丝神器
 * 
 * @author hepenghui
 *
 */
public class Diaosi {
	public static void main(String[] args) {
		boolean flag = true;
		flag &= true;
		System.out.println("true\t&=\ttrue\t==>\t" + flag);
		flag = true;
		flag &= false;
		System.out.println("true\t&=\tfalse\t==>\t" + flag);
		flag = false;
		flag &= true;
		System.out.println("false\t&=\ttrue\t==>\t" + flag);
		flag = false;
		flag &= false;
		System.out.println("false\t&=\tfalse\t==>\t" + flag + "\n");

		flag = true;
		flag |= true;
		System.out.println("true\t|=\ttrue\t==>\t" + flag);
		flag = true;
		flag |= false;
		System.out.println("true\t|=\tfalse\t==>\t" + flag);
		flag = false;
		flag |= true;
		System.out.println("false\t|=\ttrue\t==>\t" + flag);
		flag = false;
		flag |= false;
		System.out.println("false\t|=\tfalse\t==>\t" + flag + "\n");

		System.out.println("^=  相同为真，不同为假。二进制形式后按位进行异或运算，即遇相同位取0不同位取1。");
		flag = true;
		flag ^= true;
		System.out.println("true\t^=\ttrue\t==>\t" + flag);
		flag = true;
		flag ^= false;
		System.out.println("true\t^=\tfalse\t==>\t" + flag);
		flag = false;
		flag ^= true;
		System.out.println("false\t^=\ttrue\t==>\t" + flag);
		flag = false;
		flag ^= false;
		System.out.println("false\t^=\tfalse\t==>\t" + flag);
		
		int a = 1,b = 2,c = 4;//0x0001,0x0010,0x0100
		a |= b;// a = 0x0011 = 3
		b |= c;// b = 0x0110 = 6
		System.out.println(a);
		System.out.println(b);
	}

}
