package com.gaurav.testing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Testing2 {

	public static void main(String[] args) {
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String todaysDate = dateFormat.format(date).toString();
		
		String test = "select count(*) from QuestionActivity where actorWooId = ACTOR_ID and date(createdTime) = 'CREATED_TIME'";
	    test = test.replace("ACTOR_ID", "3880007");
	    test = test.replace("CREATED_TIME", todaysDate);
		
	    
	    System.out.println(test);
		
		
	}
}
