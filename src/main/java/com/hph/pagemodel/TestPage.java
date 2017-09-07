package com.hph.pagemodel;

import java.util.ArrayList;
import java.util.List;

public class TestPage {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<11170;i++){
			list.add(i);
		}
		PageModel pm = new PageModel(list, 1000);
		// 分页开始
		for(int i=0;i<pm.getTotalPages();i++){
			System.out.println("第 "+(i+1)+" 页");
			List<String> subData = pm.getObjects(i+1);
			System.out.println(subData.size());
		}
	}

}
