package com.hph.design.pattern;

public class Test {
	public static void main(String[] args) {
		
		Teacher teacher = new Teacher();
		Student s1 = new Student("张三",teacher);
		Student s2 = new Student("李四",teacher);
		Student s3 = new Student("王五",teacher);
		
		teacher.giveOrder("shut the fuck up!");
	}

}
