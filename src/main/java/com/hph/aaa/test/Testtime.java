package com.hph.aaa.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Testtime {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date d = sdf.parse("2012-12-11 00:00:00");
		
		Timestamp t = new Timestamp(d.getTime());
		
		DateTime dd =  new DateTime(t.getTime(), DateTimeZone.UTC);
		System.out.println(dd);
		
	}

}
