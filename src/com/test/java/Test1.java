package com.test.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Test1 {

	public static void main(String[] args) {
		String[] str = new String[] { "you", "wu" };
		List list = Arrays.asList(str);
		System.out.println(list);
		list.add("tiger");
		System.out.println(list);
//        第一种情况：list.add("yangguanbao"); 运行时异常。
//        第二种情况：str[0] = "gujin"; 那么list.get(0)也会随之修改。
	}

	public static String[] getResults() {
		return new String[0];
	}

	public static List<String> getResultList() {
		return Collections.emptyList();
	}

	public static Map<String, String> getResultMap() {
		return Collections.emptyMap();
	}
}
