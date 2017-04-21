package com.hph.test.enumtest;

public enum EnumTest {
	FRANK("The given name of me"), LIU("The family name of me");
	private String context;

	private String getContext() {
		return this.context;
	}
	private void setContext(String context) {
		this.context = context;
	}

	private EnumTest(String context) {
		this.context = context;
	}

	public static void main(String[] args) {
		EnumTest.FRANK.setContext("hehehehe");
		System.out.println(EnumTest.FRANK.getContext());
	}

}
