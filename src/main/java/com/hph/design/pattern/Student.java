package com.hph.design.pattern;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer{
	private String name;
	public Student(String name,Observable o){
		o.addObserver(this);
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(name+" 收到命令： "+arg);
	}

}
