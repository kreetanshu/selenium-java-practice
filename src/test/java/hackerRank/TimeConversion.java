package hackerRank;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TimeConversion {
	
	static void convert24HrsFormat(String s) {
		 String subStr = s.substring(s.length()-2);
	        String [] arr = s.substring(0,s.length()-2).split(":");
	        if(subStr.equalsIgnoreCase("AM")) {
	        	int hour = Integer.parseInt(arr[0]);
	        	if(hour==12) {
	        	System.out.println("00:"+arr[1]+":"+arr[2]);
	        	}
	        	else if(hour<12) {
	        	System.out.println(arr[0]+":"+arr[1]+":"+arr[2]);}
	        	else {
	        		System.out.println("Invalid Date");
	        	}
	        }
	        else if(subStr.equalsIgnoreCase("PM")) {
	        	int hour = Integer.parseInt(arr[0]);
	        	if(hour==12) {
	        		System.out.println("12:"+arr[1]+":"+arr[2]);
	        	}
	        	else if(hour<12) {
	        	hour=12+hour;
	        	System.out.println(String.valueOf(hour)+":"+arr[1]+":"+arr[2]);
	        	}
	        	else {
	        		System.out.println("Invalid date");
	        	}
	        }
	        else {
	        	System.out.println("Un-supported date type");
	        } 
	}
	
	static String convert24HrsJavaLib(String s) {
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("hh:mm:ssa",Locale.ENGLISH);
		DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime localTime = LocalTime.parse(s,inputFormat);
		return localTime.format(outputFormat);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "12:00:01AM";
        String s1 = "12:00:01PM";
        
        convert24HrsFormat(s);
        convert24HrsFormat(s1);
        
        System.out.println(convert24HrsJavaLib(s));
          
	}

}
