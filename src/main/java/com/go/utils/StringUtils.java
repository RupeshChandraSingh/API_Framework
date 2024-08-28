package com.go.utils;

import java.util.Random;

public class StringUtils {
	
	public static String getRandomEmail() {
		return "randomemail"+ new Random().nextInt(99999)+"@hotmail.com";
	}

}
