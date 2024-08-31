package com.singleton;

public class SingletonMain {
	
	public static void main(String args[]){
		SingletonExample	st1 = SingletonExample.getSingleTon();
		SingletonExample st2 = SingletonExample.getSingleTon();
		System.out.println(st1.hashCode());
		System.out.println(st2.hashCode());
		System.out.println(st1==st2);
		//Eager initialization 
		SingletonEagerInitial eager1 = SingletonEagerInitial.getEagerInit();
		System.out.println(eager1);
		SingletonEagerInitial eager2 = SingletonEagerInitial.getEagerInit();
		System.out.println(eager2);
	}
}
