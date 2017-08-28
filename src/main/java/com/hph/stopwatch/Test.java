package com.hph.stopwatch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StopWatch;

public class Test {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 100000; i++) {
			list.add(i + "");
		}
		
		StopWatch watch = new StopWatch("分页技术耗时统计");
		PageModel pm = new PageModel(list, 100);
		System.out.println(pm.getTotalPages());
		System.out.println(pm.totalPages);
		while (pm.isHasNextPage()) {
			watch.start(pm.getPage()+"---");
			List sublist = pm.getNextPage();
			watch.stop();
		}
		System.out.println(watch.prettyPrint());

	}

}
