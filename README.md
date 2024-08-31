# Singleton
For any java classe if we are allow to creating only one object such type of classes are called as singleton class.
Different ways to create singleton classes;

1.Eager intialization
2.Lazy intialization
3.Synchronization Block
4.Double check lock (there is a memory issue ,resolved through volatile instance variable)
5.Bill pugh solution
6.Enum singleton

Where can we apply or use the singleton concept in real time?
It is used when a single instance is required across the application, like in logging, database connections, thread pools, etc.

1.Eager intialization: The instance is created when the class is loaded. This ensures thread safety but can lead to resource wastage if the instance is never used.
public class Singleton {
    // Private static instance of the class (eager initialization)
    private static final Singleton instance = new Singleton();

    // Private constructor prevents instantiation from other classes
    private Singleton() {}

    // Public method to provide access to the instance
    public static Singleton getInstance() {
        return instance;
    }
}

2.Lazy initialization: The instance is created when it's needed. This approach is more efficient but requires careful handling of thread safety.
public class Singleton {
    // Static variable to hold the instance (lazy initialization)
    private static Singleton instance;

    // Private constructor prevents instantiation
    private Singleton() {}

    // Public method to return the instance, with lazy initialization
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


3.Synchronization Block : By using the synchronized keyword, you ensure that only one thread at a time can execute this method, preventing the creation of multiple instances.
public class Singleton {
    // Static variable to hold the instance
    private static Singleton instance;

    // Private constructor
    private Singleton() {}

    // Thread-safe method to return the instance
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

4.Double check lock: Double-checked locking is a technique used to reduce the overhead of calling the synchronized method repeatedly.
volatile is the modifier applicable only for variables not for classes and methods.
if the value of variable keeps on changeing such type of variables we have to declare with volatile modifier 
if a variable declare as volatile then for every thread a separate local copy will be created by the jvm,all inermediate modifications performed by the thread will take place in the local copy instead of master copy.
once the value got finalized before terminating the thread that final value updated in the master copy.
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

5.Bill pugh singleton: This approach is considered the best way to implement the Singleton pattern because it is both thread-safe and efficient without the need for synchronization.
public class Singleton {
    private Singleton() {}

    // Static inner class responsible for holding the Singleton instance
    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    // Method to provide the global point of access to the instance
    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}

6.Enum singleton :
using Enum is a very effective way to implement Singleton as it is thread-safe, ensures a single instance, and is also resistant to reflection and serialization attacks.
public enum Singleton {
    INSTANCE;

    public void someMethod() {
        // method implementation
    }
}

disadvantages of Singleton?
It can introduce global state into the application, making the code harder to test and debug.
It can lead to tight coupling between classes.
The Singleton class instance remains in memory for the lifetime of the application.
