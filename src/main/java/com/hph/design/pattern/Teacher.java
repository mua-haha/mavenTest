package com.hph.design.pattern;

import java.util.Observable;

public class Teacher extends Observable {

	public void giveOrder(String order) {
		setChanged();
		notifyObservers(order);
	}

}
