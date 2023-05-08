package com.masai.utility;

public class IdGeneration {
	public static int idGenerator() {
		int x = (int)(Math.random()*100000000);
		return x;
	}
}
