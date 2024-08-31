package com.singleton;

public class DoubleCheckedLock {
	private static volatile DoubleCheckedLock doubleCheckInstance;
	
	public static DoubleCheckedLock getInstance() {
		if(doubleCheckInstance == null) {
			synchronized (DoubleCheckedLock.class) {
				if(doubleCheckInstance == null) {
					doubleCheckInstance = new DoubleCheckedLock();
				}
			}
		}
		return doubleCheckInstance;
	}
}
