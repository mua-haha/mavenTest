package com.hph.excel;

import org.springframework.util.StopWatch;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		PoiExcelProvider p = new PoiExcelProvider("C:/11/aa.xlsx");
		StopWatch watch = new StopWatch("任务耗时统计");
		watch.start("读取excel");
		int i=0;
		while (p.hasNext()) {
			System.out.println(i++ +"--"+p.next());
		}
		watch.stop();
		System.out.println(watch.prettyPrint());
		
		// 11659条 03492
		// 22530条 06280
		// 32920  08603
		// 45539  11252
		// 
		
		
	}

}
