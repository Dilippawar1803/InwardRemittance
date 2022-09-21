package com.pageFactory.Utils;


public class LocatorStrategy {
	
	private static String locatorID="";

	public static String getLocatorID() {
		return locatorID;
	}

	public static void setLocatorID(String locatorID) {
		LocatorStrategy.locatorID = locatorID;
	}


}
