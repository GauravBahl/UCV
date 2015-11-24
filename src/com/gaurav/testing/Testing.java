package com.gaurav.testing;

import java.util.ArrayList;
import java.util.List;

public class Testing {
	
	public static void main(String[] args) {
		String userLocale="en-US";
		userLocale = (userLocale != null && userLocale.length()>2) ? userLocale.substring(0, 2) : userLocale;
		System.out.println(userLocale);
		
		
		List<String> l = new ArrayList<String>();
		l.add("1");
		System.out.println(l);
		
		
	}
}
