package com.singleton;

public class BillPughSingleton {
	private BillPughSingleton() {}

    // Static inner class responsible for holding the Singleton instance
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // Method to provide the global point of access to the instance
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
