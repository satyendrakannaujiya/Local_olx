package com.satyendra.idgeneration;
import java.util.Date;


public class IdGeneration {
         private static String itemid;
         private static String userid;
	  
	public static String itemid(String name,String price)
	{
		Date date = new Date();
		int hour=date.getHours();
		int minute = date.getMinutes();
		  itemid=name+price+hour+minute;
		  return itemid;
	}
	public static String userid(String name,String mobile)
	{
		Date date = new Date();
		int hour=date.getHours();
		int minute = date.getMinutes();
		  userid=name+mobile+hour+minute;
		  return userid;
	}
	
}
