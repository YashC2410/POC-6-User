package com.poc6.user;

public class Test {

	public void div(int a,int b) {
		System.out.println("Adding Division");
		if(b == 0) {
			throw new ArithmeticException("Division By Zero");
		}
		else {
			System.out.println("Division of a and b is: "+a/b);
		}
	}
	
	public void sub(int a,int b) {
		System.out.println("Subtraction is: "+(a-b));
	}
	
}
