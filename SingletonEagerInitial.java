package com.singleton;

public class SingletonEagerInitial {
	private static SingletonEagerInitial eagerInitialization = new SingletonEagerInitial();
	private SingletonEagerInitial() {
		
	}
	//factory method()
	public static SingletonEagerInitial getEagerInit() {
		return eagerInitialization;
	}
}
