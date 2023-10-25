package com.javabrains;

import java.util.Arrays;

public class TestClass implements Interface1,Interface2{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interface2 int2=new TestClass();
		int2.sayHello();
		
		int[]   ints1 = new int[10];
		int[]   ints2 = new int[10];

		for(int i=0; i < ints1.length; i++){
		    ints1[i] = 10 - i;
		}
		for(int i=0; i < ints2.length; i++){
		    ints2[i] = i+1;
		}
		
		System.out.println(java.util.Arrays.equals(ints1, ints2));
		Arrays.sort(ints1);
		
		System.out.println(java.util.Arrays.toString(ints1));
		System.out.println(java.util.Arrays.toString(ints2));
		System.out.println(java.util.Arrays.equals(ints1, ints2));
		
		String one   = "abc";
		String two   = "def";
		String three = "abc";
		String four  = "ABC";
		String one1   = new String("abc1");
		String two1   = new String("def1");
		String three1 = new String("abc1");
		String four1  = new String("ABC1");

		System.out.println( one.equals(two) );
		System.out.println( one.equals(three) );
		System.out.println( one.equals(four) );
		System.out.println( one1.equals(two1) );
		System.out.println( one1.equals(three1) );
		System.out.println( one1.equals(four1) );
		System.out.println( one==two);
		System.out.println( one==three);
		System.out.println( one==four);
		System.out.println( one1==two1);
		System.out.println( one1==three1);
		System.out.println( one1==four1);
	}

	public void sayHello() {
		System.out.println("Say hello");
		
	}

}
