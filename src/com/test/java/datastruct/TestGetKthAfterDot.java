package com.test.java.datastruct;

public class TestGetKthAfterDot {

	public static void main(String[] args) {

		System.out.println(getKthAfterDot(3, 3, 4));
		System.out.println(getKthAfterDot(6, 3, 4));
		
		
		System.out.println("--------------");
		System.out.println(getKthAfterDot(3, 7, 1));
		System.out.println(getKthAfterDot(3, 7, 2));
		System.out.println(getKthAfterDot(3, 7, 3));
		System.out.println(getKthAfterDot(3, 7, 4));
		
		System.out.println("--------------");
		System.out.println(getKthAfterDot(7, 3, 1));
		System.out.println(getKthAfterDot(7, 3, 2));
		System.out.println(getKthAfterDot(7, 3, 3));
		System.out.println(getKthAfterDot(7, 3, 4));
	}

	public static int getKthAfterDot(int x, int y, int k){
		if(x == y || x % y == 0){
			return 0;
		}
		
		int m = x % y;
		
		int index = 0;
		int value = 0;

		while(m != 0) {
			index++;
			if(index == k){
				value = m * 10 / y;
				break;
			}
			
			m = m * 10 % y;
		}
		
		return value;
	}
}
