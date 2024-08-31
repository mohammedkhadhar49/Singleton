package com.singleton;

public class SingletonExample {
	private static SingletonExample st= null;
	//private constructor
	private SingletonExample() {
		
	}
	//factory method()
	public static synchronized SingletonExample getSingleTon() {
		if(st == null) {
			st = new SingletonExample();
		}
		return st;
	}
}
